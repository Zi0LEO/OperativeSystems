package EserciziEsame.AziendaAgricola;

import java.util.Random;

public class Cliente implements Runnable{

    private final int MAX_SACCHI = 10;
    private final int MIN_SACCHI = 1;

    private final Random random = new Random();

    AziendaAgricola azienda;

    public Cliente(AziendaAgricola azienda){
        this.azienda = azienda;
    }

    @Override
    public void run(){
        int sacchiDaAcquistare = random.nextInt(MIN_SACCHI, MAX_SACCHI);
        azienda.pagaSacchi(sacchiDaAcquistare);
        azienda.prendiSacchi(sacchiDaAcquistare);
    }
}
