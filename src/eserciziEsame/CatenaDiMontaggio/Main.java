package eserciziEsame.CatenaDiMontaggio;

import java.util.LinkedList;

public class Main {
  public static void main(String[] var0) {
    LinkedList<int[]> var1 = new LinkedList<>();
    var1.add(new int[] { 2, 4 });
    var1.add(new int[] { 4, 3 });
    var1.add(new int[] { 5, 6 });
    CatenaDiMontaggioSem var2 = new CatenaDiMontaggioSem();
    Assemblatore var3 = new Assemblatore(var2, var1);
    (new Thread(var3)).start();

    int var4;
    Produttore var5;
    for (var4 = 0; var4 < 3; ++var4) {
      var5 = new Produttore(var2, 0);
      (new Thread(var5)).start();
    }

    for (var4 = 0; var4 < 4; ++var4) {
      var5 = new Produttore(var2, 1);
      (new Thread(var5)).start();
    }
  }
}
