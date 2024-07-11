package eserciziEsame.CatenaDiMontaggio;

import java.util.concurrent.TimeUnit;

public class Produttore implements Runnable {
  public final int PEZZO_SX = 0;
  public final int PEZZO_DX = 1;
  final int TIPO;

  public Produttore(int tipo) {
    TIPO = tipo;
  }
  
  @Override
  public void run() {
    try {

      if (TIPO == 0) {
        TimeUnit.MINUTES.sleep(10);

      } else {
        TimeUnit.MINUTES.sleep(15);
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
