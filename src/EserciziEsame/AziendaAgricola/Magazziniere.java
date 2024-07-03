package EserciziEsame.AziendaAgricola;

public class Magazziniere implements Runnable {

  AziendaAgricola azienda;

  public Magazziniere(AziendaAgricola azienda) {
    this.azienda = azienda;
  }

  @Override
  public void run() {
    while (true) {
      azienda.resettaMagazzino();
    }
  }
}
