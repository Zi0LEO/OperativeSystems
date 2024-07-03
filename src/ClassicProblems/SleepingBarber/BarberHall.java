package ClassicProblems.SleepingBarber;

public abstract class BarberHall {

  protected final int chairsNumber;
  protected int availableChairs;

  public BarberHall(int chairsNumber) {
    this.chairsNumber = chairsNumber;
    availableChairs = chairsNumber;
  }

  public abstract void cutHair() throws InterruptedException;

  public abstract boolean waitForCut() throws InterruptedException;

  public void test(int numCustomers) {
    new Thread(new Barber(this)).start();
    for (int i = 0; i < numCustomers; i++) {
      new Thread(new Customer(this, i)).start();
    }
  }

  public static void main(String[] args) {
    BarberHall hall = new BarberHallLock(5);
    hall.test(6);
  }
}
