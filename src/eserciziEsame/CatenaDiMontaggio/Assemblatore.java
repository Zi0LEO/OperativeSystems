package eserciziEsame.CatenaDiMontaggio;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Assemblatore implements Runnable{

  LinkedList<int[]> queue;
  protected CatenaDiMontaggioA cdm;

  public void run() {
    try {
      TimeUnit.MINUTES.sleep(20);
    } catch (Exception e) {
    }
  }

  public void assegnaUnita(){
    int[] daProdurre = queue.pop();
    cdm.richiediProduzione(daProdurre[0], daProdurre[1]);
  }
}
