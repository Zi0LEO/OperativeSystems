package EserciziEsame.Casello;

import java.util.Random;

public abstract class Casello {

  protected int incasso;
  protected int porte;
  protected int tariffa;

  public Casello(int porte, int tariffa) {
    this.porte = porte;
    this.tariffa = tariffa;
    incasso = 0;
  }

  public int scegliPorta() {
    Random random = new Random();
    return random.nextInt(porte);
  }

  public abstract void mettiInCoda(int porta) throws InterruptedException;

  public abstract void paga(int chilometriPercorsi) throws InterruptedException;

  public abstract void lascia(int porta);

  public void test(int numVeicoli) throws InterruptedException {

    for (int i = 0; i < numVeicoli; i++) {
      new Thread(new Veicolo(this)).start();
    }

    /*
     * while(true){
     * System.out.println(this.incasso); //just for debug if needed
     * Thread.sleep(3_000);
     * }
     */

  }
}
