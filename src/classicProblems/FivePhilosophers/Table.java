package classicProblems.FivePhilosophers;

public abstract class Table {

  public static final int NUM_PHILOSOPHERS = 5;

  public abstract void takeSticks(int index) throws InterruptedException;

  public abstract void leaveSticks(int index);

  protected void test() {
    for (int i = 0; i < NUM_PHILOSOPHERS; i++) new Thread(new Philosopher(i, this)).start();
  }
}
