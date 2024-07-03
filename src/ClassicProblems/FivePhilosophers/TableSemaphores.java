package ClassicProblems.FivePhilosophers;

import java.util.concurrent.Semaphore;

public class TableSemaphores extends Table {

  Semaphore[] sticks = new Semaphore[NUM_PHILOSOPHERS];

  public TableSemaphores() {
    for (int i = 0; i < NUM_PHILOSOPHERS; i++) sticks[i] = new Semaphore(1);
  }

  @Override
  public void takeSticks(int index) throws InterruptedException {
    sticks[index].acquire();
    sticks[(index + 1) % NUM_PHILOSOPHERS].acquire();
  }

  @Override
  public void leaveSticks(int index) {
    sticks[index].release();
    sticks[(index + 1) % NUM_PHILOSOPHERS].release();
  }

  public static void main(String[] args) {
    Table table = new TableSemaphores();
    table.test();
  }
}
