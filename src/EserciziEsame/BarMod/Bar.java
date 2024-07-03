package EserciziEsame.BarMod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Bar {

  protected final int CASSA = 0;
  protected final int BANCONE = 1;
  protected final int NUM_FILE = 2;
  protected final Random random = new Random();

  public abstract int scegli();

  public abstract void inizia(int i) throws InterruptedException;

  public abstract void finisci(int i);

  protected void faiCose(int i) throws InterruptedException {
    switch (i) {
      case CASSA:
        TimeUnit.SECONDS.sleep(random.nextInt(1, 3));
        break;
      case BANCONE:
        TimeUnit.SECONDS.sleep(random.nextInt(20, 40));
        break;
      default:
        System.out.println("??");
    }
  }
}
