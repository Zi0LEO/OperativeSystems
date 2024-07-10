package classicProblems.ReadersWriters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Reader implements Runnable {

  private static final int MIN_READING_TIME = 1;
  private static final int MAX_READING_TIME = 4;
  private static final int MIN_WAITING_TIME = 6;
  private static final int MAX_WAITING_TIME = 10;
  private final Random random = new Random();

  private final Book book;

  public Reader(Book book) {
    this.book = book;
  }

  @Override
  public void run() {
    try {
      while (true) {
        book.startReading();
        read();
        book.stopReading();
        doSomethingElse();
      }
    } catch (InterruptedException ignored) {
    }
  }

  private void read() throws InterruptedException {
    System.out.println("Reader " + Thread.currentThread().getId() + " is reading");
    spendTime(MIN_READING_TIME, MAX_READING_TIME);
  }

  private void doSomethingElse() throws InterruptedException {
    spendTime(MIN_WAITING_TIME, MAX_WAITING_TIME);
  }

  private void spendTime(int min, int max) throws InterruptedException {
    TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
  }
}
