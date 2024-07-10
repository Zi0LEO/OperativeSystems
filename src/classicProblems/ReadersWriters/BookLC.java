package classicProblems.ReadersWriters;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookLC extends Book {

  private int readersNumber;
  private final Lock lock = new ReentrantLock();
  private final Condition canWrite = lock.newCondition();
  private final Condition canRead = lock.newCondition();
  private boolean isWriting = false;

  public BookLC() {
    this.readersNumber = 0;
  }

  @Override
  public void startWriting() throws InterruptedException {
    lock.lock();
    try {
      while (readersNumber > 0 || isWriting) canWrite.await();
      isWriting = true;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void stopWriting() {
    lock.lock();
    try {
      canRead.signalAll();
      canWrite.signal();
      isWriting = false;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void startReading() throws InterruptedException {
    lock.lock();
    try {
      while (isWriting) canRead.await();
      readersNumber++;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void stopReading() {
    lock.lock();
    try {
      readersNumber--;
      if (readersNumber == 0) canWrite.signal();
    } finally {
      lock.unlock();
    }
  }
}
