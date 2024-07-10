package esercitazione04.Esercizio4_5;

import java.util.concurrent.Semaphore;

public class Esercizio4_5Test {

  static Semaphore semA = new Semaphore(2);
  static Semaphore semB = new Semaphore(0);

  static class APrinter extends Thread {
    @Override
    public void run() {
      try {
        semA.acquire();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.print("A");
      semB.release();
    }
  }

  static class BPrinter extends Thread {

    @Override
    public void run() {
      try {
        semB.acquire(2);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.print("B ");
      semA.release(2);
    }
  }

  public static void main(String[] args) {
    for (;;) {
      new APrinter().start();
      new BPrinter().start();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ignored) {
      }
    }
  }
}
