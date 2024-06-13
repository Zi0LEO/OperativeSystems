package EserciziEsame.Visualizzatore;

import java.util.Random;

public class Utente extends Thread{

    private static final int MIN_STRINGS = 1;
    private static final int MAX_STRINGS = 5;

    private final ExerciseQueue queue;
    private final int id;
    private final Random random = new Random();

    public Utente(ExerciseQueue queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            int numberOfStrings = random.nextInt(MIN_STRINGS, MAX_STRINGS);
            for (int i = 0; i < numberOfStrings; i++) {
                try {
                    queue.inserisciStringa(String.format("Stringa %d dell'utente %d \n", i, id));
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
