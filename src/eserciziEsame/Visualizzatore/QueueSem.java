package EserciziEsame.Visualizzatore;

import java.util.concurrent.Semaphore;

public class QueueSem extends ExerciseQueue {

  private final int MAX_LENGTH = 100;

  private final Semaphore mutex = new Semaphore(1);
  private final Semaphore postiDisponibili = new Semaphore(MAX_LENGTH);
  private final Semaphore queueVuota = new Semaphore(0);

  @Override
  public void inserisciStringhe(int numStrings, int id) throws InterruptedException {
    postiDisponibili.acquire(numStrings);
    mutex.acquire();
    for (int i = 0; i < numStrings; i++) {
      queue.add(buildString(i, id));
      queueVuota.release();
    }
    mutex.release();
  }

  @Override
  public String rimuoviStringa() throws InterruptedException {
    queueVuota.acquire();
    mutex.acquire();
    String ret = queue.pop();
    mutex.release();
    postiDisponibili.release();
    return ret;
  }
}
