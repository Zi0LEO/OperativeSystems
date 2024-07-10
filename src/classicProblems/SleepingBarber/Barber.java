package classicProblems.SleepingBarber;

import java.util.concurrent.TimeUnit;

public class Barber implements Runnable {

  private final BarberHall hall;

  public Barber(BarberHall hall) {
    this.hall = hall;
  }

  @Override
  public void run() {
    while (true) {
      try {
        hall.cutHair();
        System.out.println("Cutting...");
        cut();
      } catch (InterruptedException i) {
        System.out.print("Exception in barber");
      }
    }
  }

  private static void cut() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
  }
}
