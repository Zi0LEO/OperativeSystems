package EserciziEsame.Visualizzatore;

import java.util.LinkedList;

public abstract class ExerciseQueue {

    private static final int NUM_VISUALIZZATORI = 1;
    private static final int NUM_UTENTI = 10;

    protected LinkedList<String> queue;

    public ExerciseQueue(){
        queue = new LinkedList<>();
    }

    public abstract void inserisciStringa(String string) throws InterruptedException;

    public abstract String rimuoviStringa() throws InterruptedException;
    public void test(){

        for(int i = 0; i < NUM_VISUALIZZATORI; i++)
            new Visualizzatore(this).start();

        for(int i = 0; i < NUM_UTENTI; i++)
            new Utente(this, i).start();

    }
}
