package EserciziEsame.BarMod;

import java.util.concurrent.Semaphore;

public class BarSemaphores extends Bar {

  protected Semaphore mutex = new Semaphore(1);
  protected Semaphore[] daServire = new Semaphore[NUM_FILE];
  protected int[] personeInFila = new int[NUM_FILE];

  public BarSemaphores() {
    daServire[CASSA] = new Semaphore(1, true);
    daServire[BANCONE] = new Semaphore(4, true);
  }

  public int scegli() {
    if (personeInFila[CASSA] <= personeInFila[BANCONE]) return CASSA;
    return BANCONE;
  }

  @Override
  public void inizia(int i) throws InterruptedException {
    mutex.acquire();
    personeInFila[i]++;
    mutex.release();

    daServire[i].acquire();

    mutex.acquire();
    personeInFila[i]--;
    mutex.release();

    faiCose(i);
  }

  @Override
  public void finisci(int i) {
    daServire[i].release();
  }
}
