package classicProblems.ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

  protected Buffer buffer;

  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int object = buffer.get();
        consume(object);
      }
    } catch (InterruptedException ignored) {
    }
  }

  private void consume(int i) {
    try {
      System.out.format("consumer %d is consuming \n", Thread.currentThread().getId());
      TimeUnit.SECONDS.sleep(i);
    } catch (InterruptedException ignored) {
    }
  }
}
