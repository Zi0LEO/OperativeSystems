package eserciziEsame.CatenaDiMontaggio;

public abstract class CatenaDiMontaggioA {
  abstract void richiediProduzione(int var1, int var2);

  abstract void produci(int var1) throws InterruptedException;

  abstract void assembla() throws InterruptedException;
}
