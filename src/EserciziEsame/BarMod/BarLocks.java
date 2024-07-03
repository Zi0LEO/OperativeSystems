package EserciziEsame.BarMod;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarLocks extends Bar {

  protected int[] postiDisponibili = new int[NUM_FILE];
  protected Lock lock = new ReentrantLock();
  protected Condition[] pieno = new Condition[NUM_FILE];
  private LinkedList<Thread>[] file = new LinkedList[NUM_FILE];

  public BarLocks() {
    for (int i = 0; i < NUM_FILE; i++) {
      file[i] = new LinkedList<>();
      pieno[i] = lock.newCondition();
    }
    postiDisponibili[CASSA] = 1;
    postiDisponibili[BANCONE] = 4;
  }

  @Override
  public int scegli() {
    if (file[CASSA].size() <= file[BANCONE].size()) return CASSA;
    return BANCONE;
  }

  @Override
  public void inizia(int i) throws InterruptedException {
    lock.lock();
    try {
      file[i].add(Thread.currentThread());
      while (!puoEssereServito(i)) pieno[i].await();

      file[i].removeFirst();
      postiDisponibili[i]--;

    } finally {
      lock.unlock();
    }
    faiCose(i);
  }

  @Override
  public void finisci(int i) {
    lock.lock();
    try {
      postiDisponibili[i]++;
      pieno[i].signalAll();
    } finally {
      lock.unlock();
    }
  }

  private boolean puoEssereServito(int id) {
    return file[id].indexOf(Thread.currentThread()) < postiDisponibili[id];
  }
}
