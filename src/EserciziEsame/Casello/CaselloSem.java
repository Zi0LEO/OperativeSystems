package EserciziEsame.Casello;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CaselloSem extends Casello{

    protected Semaphore mutex = new Semaphore(1);
    protected Semaphore[] listaPorte = new Semaphore[porte];
    protected final Random random =  new Random();

    public CaselloSem(int porte, int tariffa) {
        super(porte, tariffa);
        for(int i = 0; i < porte; i++)
            listaPorte[i] = new Semaphore(1, true);
    }

    @Override
    public void mettiInCoda(int porta) throws InterruptedException {
        listaPorte[porta].acquire();
    }

    @Override
    public void paga(int chilometriPercorsi) throws InterruptedException {
        TimeUnit.SECONDS.sleep(random.nextInt(Veicolo.MIN_TIME_TO_PAY, Veicolo.MAX_TIME_TO_PAY));
        mutex.acquire();
        incasso += chilometriPercorsi * tariffa;
        mutex.release();
    }

    @Override
    public void lascia(int porta) {
        listaPorte[porta].release();
    }
}
