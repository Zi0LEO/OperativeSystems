package EserciziEsame.Casello;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Veicolo implements Runnable{

    public static final int MIN_KM = 50;
    public static final int MAX_KM = 100;
    public static final int TIME_FOR_KM = 40;

    public static final int MIN_TIME_TO_PAY = 3;
    public static final int MAX_TIME_TO_PAY = 6;

    public final Casello casello;
    public final Random random = new Random();

    public Veicolo(Casello casello) {
        this.casello = casello;
    }

    @Override
    public void run() {
        try{
            int kmPercorsi = viaggia();
            int porta = casello.scegliPorta();
            casello.mettiInCoda(porta);
            casello.paga(kmPercorsi);
            casello.lascia(porta);
        }catch(InterruptedException ignored){}

    }

    private int viaggia() throws InterruptedException {
        int kmPercorsi = random.nextInt(MIN_KM, MAX_KM);
        TimeUnit.SECONDS.sleep((long) TIME_FOR_KM * kmPercorsi);
        return kmPercorsi;
    }
}
