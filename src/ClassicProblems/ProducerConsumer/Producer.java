package ClassicProblems.ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable {

  private static final int MAX_WAITING = 5;
  private static final int MAX_ELEMENT = 10;
  private final Random random = new Random();

  protected Buffer buffer;

  public Producer(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int object = makeObject();
        buffer.put(object);
      }
    } catch (InterruptedException ignored) {
    }
  }

  private int makeObject() {
    try {
      System.out.format("producer %d is producing \n", Thread.currentThread().getId());
      Thread.sleep(random.nextInt(MAX_WAITING));
    } catch (InterruptedException ignored) {
    }
    return random.nextInt(MAX_ELEMENT);
  }
}
