package eserciziEsame.CatenaDiMontaggio;

public class Produttore implements Runnable {
  public static final int PEZZO_SX = 0;
  public static final int PEZZO_DX = 1;
  final int TIPO;
  public CatenaDiMontaggioA cdm;

  public Produttore(CatenaDiMontaggioA var1, int var2) {
    this.TIPO = var2;
    this.cdm = var1;
  }

  public void run() {
    while (true) {
      try {
        this.cdm.produci(this.TIPO);
      } catch (Exception var2) {
      }
    }
  }
}
