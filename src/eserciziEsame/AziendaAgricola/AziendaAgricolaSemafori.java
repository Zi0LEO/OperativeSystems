package eserciziEsame.AziendaAgricola;

import java.util.concurrent.Semaphore;

public class AziendaAgricolaSemafori extends AziendaAgricola {

  protected Semaphore magazzinoVuoto = new Semaphore(0, true);
  protected Semaphore sacchiDisponibili = new Semaphore(MAX_CAPACITA, true);
  protected Semaphore mutexCassa = new Semaphore(1, true);

  @Override
  protected void pagaSacchi(int sacchi) {
    try {
      mutexCassa.acquire();
      incasso += PREZZO_SACCO * sacchi;

      mutexCassa.release();
    } catch (InterruptedException ignored) {
    }
  }

  @Override
  protected void prendiSacchi(int sacchi) {
    try {
      for (int i = 0; i < sacchi; i++) {
        sacchiDisponibili.acquire();
        magazzinoVuoto.release();
        spostaSacco();
      }
    } catch (InterruptedException ignored) {
    }
  }

  @Override
  protected void resettaMagazzino() {
    try {
      magazzinoVuoto.acquire(MAX_CAPACITA);
      riempiMagazzino();
    } catch (InterruptedException ignored) {
    }
    sacchiDisponibili.release(MAX_CAPACITA);
  }
}
