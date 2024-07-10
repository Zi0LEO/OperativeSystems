package eserciziEsame.BarMod;

public class Cliente implements Runnable {

  protected final Bar bar;
  private final int id;

  public Cliente(Bar bar, int id) {
    this.bar = bar;
    this.id = id;
  }

  @Override
  public void run() {
    int idBar = bar.scegli();
    for (int i = 0; i < 2; i++) {
      try {
        bar.inizia(idBar);
        bar.finisci(idBar);
        idBar = cambia(idBar);
      } catch (InterruptedException ignored) {
      }
    }
  }

  private int cambia(int i) {
    if (i == 0) return 1;
    return 1;
  }
}
