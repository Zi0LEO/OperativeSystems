package esercitazione04.Esercizio4_3;

import Esercitazione03.Esercizio3_1.ElementModifier;
import Esercitazione03.Esercizio3_1.Matrix;
import java.util.concurrent.Semaphore;

public class ElementModifierSemaphores extends ElementModifier {

  static Semaphore mutex = new Semaphore(1);

  public ElementModifierSemaphores(
      int index, int times, boolean toIncrease, int length, Matrix matrix) {
    super(index, times, toIncrease, length, matrix);
  }

  @Override
  public void run() {
    for (int t = 0; t < times; t++) {
      for (int i = 0; i < this.length; i++) {
        if (toIncrease) {
          try {
            mutex.acquire();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          matrix.increment(i, index);
          mutex.release();
        } else {
          try {
            mutex.acquire();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          matrix.decrement(index, i);
          mutex.release();
        }
      }
    }
  }
}
