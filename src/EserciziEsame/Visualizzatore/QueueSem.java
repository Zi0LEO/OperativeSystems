package EserciziEsame.Visualizzatore;

import java.util.concurrent.Semaphore;

public class QueueSem extends ExerciseQueue{

    private final int MAX_LENGTH = 100;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore postiDisponibili = new Semaphore(MAX_LENGTH);
    private final Semaphore queueVuota = new Semaphore(0);


    @Override
    public void inserisciStringa(String string) throws InterruptedException{
        postiDisponibili.acquire();
        mutex.acquire();
        queue.add(string);
        queueVuota.release();
        mutex.release();
    }

    @Override
    public String rimuoviStringa() throws InterruptedException{
        queueVuota.acquire();
        mutex.acquire();
        String ret = queue.pop();
        mutex.release();
        postiDisponibili.release();
        return ret;
    }
}
