package eserciziEsame.AziendaAgricola;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AziendaAgricolaLock extends AziendaAgricola {

  protected Lock lock = new ReentrantLock();
  protected Condition cassaImpegnata = lock.newCondition();
  protected Condition magazzinoVuoto = lock.newCondition();
  protected Condition ciSonoSacchiDisponibili = lock.newCondition();
  protected LinkedList<Thread> cassa = new LinkedList<>();
  protected LinkedList<Thread> magazzino = new LinkedList<>();

  protected int sacchiDisponibili;

  public AziendaAgricolaLock() {
    super();
    sacchiDisponibili = MAX_CAPACITA;
  }

  @Override
  protected void pagaSacchi(int sacchi) {
    lock.lock();
    try {
      cassa.add(Thread.currentThread());
      while (cassa.getFirst() != Thread.currentThread()) cassaImpegnata.await();
      incasso += PREZZO_SACCO * sacchi;
      cassa.removeFirst();
      cassaImpegnata.signalAll();
    } catch (InterruptedException ignored) {
    } finally {
      lock.unlock();
    }
  }

  @Override
  protected void prendiSacchi(int sacchi) {
    lock.lock();
    try {
      magazzino.add(Thread.currentThread());
      for (int i = 0; i < sacchi; i++) {
        while (sacchiDisponibili == 0 || Thread.currentThread() != magazzino.getFirst())
          magazzinoVuoto.await();
        spostaSacco();
        sacchiDisponibili--;
        if (sacchiDisponibili == 0) ciSonoSacchiDisponibili.signal();
      }
      magazzino.removeFirst();
    } catch (InterruptedException ignored) {
    } finally {
      lock.unlock();
    }
  }

  @Override
  protected void resettaMagazzino() {
    lock.lock();
    try {
      while (!(sacchiDisponibili == 0)) ciSonoSacchiDisponibili.await();
      sacchiDisponibili = MAX_CAPACITA;
      riempiMagazzino();
      magazzinoVuoto.signalAll();
    } catch (InterruptedException ignored) {
    } finally {
      lock.unlock();
    }
  }
}
