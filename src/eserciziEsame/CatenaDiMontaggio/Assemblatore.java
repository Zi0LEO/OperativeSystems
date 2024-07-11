package eserciziEsame.CatenaDiMontaggio;

import java.util.LinkedList;

public class Assemblatore implements Runnable {
  LinkedList<int[]> queue;
  protected CatenaDiMontaggioA cdm;

  public Assemblatore(CatenaDiMontaggioA var1, LinkedList<int[]> var2) {
    this.cdm = var1;
    this.queue = var2;
  }

  public void run() {
    int[] var1 = new int[2];

    while (!this.queue.isEmpty()) {
      var1 = (int[]) this.queue.pop();

      try {
        this.cdm.richiediProduzione(var1[0], var1[1]);
        this.cdm.assembla();
      } catch (Exception var3) {
      }
    }
  }
}
