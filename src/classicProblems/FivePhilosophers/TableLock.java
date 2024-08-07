package classicProblems.FivePhilosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TableLock extends Table {

  protected final Lock lock = new ReentrantLock(true);
  protected Condition[] self = new Condition[NUM_PHILOSOPHERS];
  protected States[] state = new States[NUM_PHILOSOPHERS];

  protected enum States {
    thinking,
    hungry,
    eating
  }

  public TableLock() {
    for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
      self[i] = lock.newCondition();
      state[i] = States.thinking;
    }
  }

  @Override
  public void takeSticks(int index) throws InterruptedException {
    lock.lock();
    state[index] = States.hungry;
    try {
      testIfCanEat(index);
      while (!(state[index] == States.eating)) {
        self[index].await();
      }
    } finally {
      lock.unlock();
    }
  }

  private void testIfCanEat(int index) {
    if (!(state[leftPhilosopher(index)] == States.eating)
        && !(state[rightPhilosopher(index)] == States.eating)) {
      state[index] = States.eating;
      self[index].signal();
    }
  }

  private int leftPhilosopher(int index) {
    return (index + NUM_PHILOSOPHERS - 1) % NUM_PHILOSOPHERS;
  }

  private int rightPhilosopher(int index) {
    return (index + 1) % NUM_PHILOSOPHERS;
  }

  @Override
  public void leaveSticks(int index) {
    lock.lock();
    try {
      state[index] = States.thinking;
      testIfCanEat(leftPhilosopher(index));
      testIfCanEat(rightPhilosopher(index));
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    Table table = new TableLock();
    table.test();
  }
}
