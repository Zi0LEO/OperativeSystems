package EserciziEsame.Visualizzatore;

public class Visualizzatore extends Thread{

    protected ExerciseQueue queue;

    public Visualizzatore(ExerciseQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            String string = null;
            try {
                string = queue.rimuoviStringa();
            }catch(InterruptedException ignored){}
            System.out.print(string);
        }
    }
}
