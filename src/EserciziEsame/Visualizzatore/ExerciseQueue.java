package EserciziEsame.Visualizzatore;

import java.util.LinkedList;

public abstract class ExerciseQueue {

  private static final int NUM_VISUALIZZATORI = 1;
  private static final int NUM_UTENTI = 2;

  protected LinkedList<String> queue;

  public ExerciseQueue() {
    queue = new LinkedList<>();
  }

  public abstract void inserisciStringhe(int numStrings, int id) throws InterruptedException;

  public abstract String rimuoviStringa() throws InterruptedException;

  protected String buildString(int i, int id) {
    return String.format("Stringa %d dell'utente %d \n", i, id);
  }

  public void test() {

    for (int i = 0; i < NUM_VISUALIZZATORI; i++) new Visualizzatore(this).start();

    for (int i = 0; i < NUM_UTENTI; i++) new Utente(this, i).start();
  }
}
