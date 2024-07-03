package ClassicProblems.SleepingBarber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarberHallLock extends BarberHall {

  protected Lock lock = new ReentrantLock(true);
  protected Condition availableCustomers = lock.newCondition();
  protected Condition cuttingChair = lock.newCondition();
  protected boolean freeChair = false;

  public BarberHallLock(int chairsNumber) {
    super(chairsNumber);
  }

  @Override
  public void cutHair() throws InterruptedException {
    lock.lock();
    try {
      while (availableChairs == chairsNumber) availableCustomers.await();
      freeChair = true;
      cuttingChair.signal();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public boolean waitForCut() throws InterruptedException {
    lock.lock();
    try {
      if (availableChairs == 0) return false;
      availableChairs--;
      availableCustomers.signal();
      while (!freeChair) cuttingChair.await();
      freeChair = false;
      availableChairs++;
      return true;
    } finally {
      lock.unlock();
    }
  }
}
