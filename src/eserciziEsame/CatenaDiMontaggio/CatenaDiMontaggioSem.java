package eserciziEsame.CatenaDiMontaggio;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CatenaDiMontaggioSem extends CatenaDiMontaggioA {
  Semaphore[] daProdurre = new Semaphore[2];
  Semaphore daProdurreTot = new Semaphore(0);
  int sX, dX;

  public CatenaDiMontaggioSem() {
    this.daProdurre[0] = new Semaphore(0);
    this.daProdurre[1] = new Semaphore(0);
  }

  public void richiediProduzione(int var1, int var2) {
    this.daProdurre[0].release(var1);
    this.daProdurre[1].release(var2);
    this.daProdurreTot = new Semaphore(1 - (var1 + var2));
    sX = var1;
    dX = var2;
  }

  void produci(int var1) throws InterruptedException {
    this.daProdurre[var1].acquire();
    String pezzo = (var1 == 0) ? "sx" : "dx";
    System.out.println("Producendo pezzo " + pezzo);
    if (var1 == 0) {
      TimeUnit.SECONDS.sleep(10L);
    } else {
      TimeUnit.SECONDS.sleep(15L);
    }
    this.daProdurreTot.release();
  }

  void assembla() throws InterruptedException {
    this.daProdurreTot.acquire();
    System.out.println(
        "Assemblando componente con " + sX + " pezzi sinistri e " + dX + " pezzi destri");
    TimeUnit.SECONDS.sleep(20L);
  }
}
