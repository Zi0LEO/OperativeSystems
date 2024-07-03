package ClassicProblems.ReadersWriters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {

  private static final int MIN_WRITING_TIME = 2;
  private static final int MAX_WRITING_TIME = 3;
  private static final int MIN_WAITING_TIME = 10;
  private static final int MAX_WAITING_TIME = 20;
  private final Random random = new Random();

  private final Book book;

  public Writer(Book book) {
    this.book = book;
  }

  @Override
  public void run() {
    try {
      while (true) {
        book.startWriting();
        write();
        book.stopWriting();
        doSomethingElse();
      }
    } catch (InterruptedException ignored) {
    }
  }

  private void write() throws InterruptedException {
    System.out.println("Writer " + Thread.currentThread().getId() + " is writing");
    spendTime(MIN_WRITING_TIME, MAX_WRITING_TIME);
  }

  private void doSomethingElse() throws InterruptedException {
    spendTime(MIN_WAITING_TIME, MAX_WAITING_TIME);
  }

  private void spendTime(int min, int max) throws InterruptedException {
    TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
  }
}
