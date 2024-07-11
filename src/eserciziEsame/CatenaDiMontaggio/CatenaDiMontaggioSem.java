package eserciziEsame.CatenaDiMontaggio;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class CatenaDiMontaggioSem {
  Semaphore produttoriSx;
  Semaphore produttoriDx;
  Semaphore assemblatoreLibero =  new Semaphore(1);

  public CatenaDiMontaggioSem(LinkedList<int[]> queue, int numProduttoriSx, int numProduttoriDx){
    super(queue);
    produttoriSx = new Semaphore(numProduttoriSx);
    produttoriDx = new Semaphore(numProduttoriDx);
  }

  @Override
  public void richiediProduzione(int pezziSx, int pezziDx){
    
  }
}
