package eserciziEsame.CatenaDiMontaggio;

import java.util.LinkedList;

public abstract class CatenaDiMontaggioA {

  int[] daProdurre = new int[2];

  abstract void richiediProduzione(int pezziSx, int pezziDx);

  abstract void produci(int tipo);

  abstract void assembla();
}
