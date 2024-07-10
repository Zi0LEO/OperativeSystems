package Esercitazione04.Esercizio4_3;

import static Esercitazione03.Esercizio3_1.Test.printMatrix;

import Esercitazione03.Esercizio3_1.ElementModifier;
import Esercitazione03.Esercizio3_1.IntMatrix;
import Esercitazione03.Esercizio3_1.Matrix;

public class Esercizio4_3Test {

  static final int ROWS = 3;
  static final int COLUMNS = 4;

  public static void main(String[] args) throws InterruptedException {

    Matrix matrixNTS = new IntMatrix(ROWS, COLUMNS);
    Matrix matrixTS = new IntMatrix(ROWS, COLUMNS);

    System.out.println("NON THREAD_SAFE: ");
    printMatrix(matrixNTS);
    System.out.println("THREAD-SAFE: ");
    printMatrix(matrixTS);

    final int TIMES = 500000;
    final boolean TO_INCREASE = true;

    Thread[] threads = new Thread[(ROWS + COLUMNS) * 2];
    for (int i = 0; i < COLUMNS; i++) {
      ElementModifier emNTS = new ElementModifier(i, TIMES, TO_INCREASE, ROWS, matrixNTS);
      ElementModifier emTS = new ElementModifierSemaphores(i, TIMES, TO_INCREASE, ROWS, matrixTS);
      Thread thread = new Thread(emNTS);
      Thread thread2 = new Thread(emTS);
      thread.start();
      thread2.start();
      threads[i] = thread;
      threads[i + (threads.length / 2)] = thread2;
    }

    for (int i = 0; i < ROWS; i++) {
      ElementModifier emNTS = new ElementModifier(i, TIMES, !TO_INCREASE, COLUMNS, matrixNTS);
      ElementModifier emTS = new ElementModifierSemaphores(i, TIMES, !TO_INCREASE, COLUMNS, matrixTS);
      Thread thread = new Thread(emNTS);
      Thread thread2 = new Thread(emTS);
      thread.start();
      thread2.start();
      threads[COLUMNS + i] = thread;
      threads[COLUMNS + i + (threads.length / 2)] = thread2;
    }
    for (Thread t : threads)
      t.join();

    System.out.println("NON THREAD_SAFE: ");
    printMatrix(matrixNTS);
    System.out.println("THREAD-SAFE: ");
    printMatrix(matrixTS);
  }
}
