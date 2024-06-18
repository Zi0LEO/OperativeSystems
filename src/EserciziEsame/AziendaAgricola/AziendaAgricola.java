package EserciziEsame.AziendaAgricola;

import java.util.concurrent.TimeUnit;

public abstract class AziendaAgricola {

    protected final int MAX_CAPACITA = 200;
    protected final int PREZZO_SACCO = 3;

    protected int incasso;

    public AziendaAgricola(){
        this.incasso = 0;
    }

    protected abstract void pagaSacchi(int sacchi);

    protected abstract void prendiSacchi(int sacchi);

    protected abstract void resettaMagazzino();

    protected void spostaSacco() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
    }

    protected void riempiMagazzino() throws InterruptedException{
        TimeUnit.SECONDS.sleep(10);
    }

    public void test(int numClienti) throws InterruptedException {
        Thread[] threads =  new Thread[numClienti];
        for(int i = 0; i < numClienti; i++) {
            threads[i] = new Thread(new Cliente(this));
            threads[i].start();
        }

        Thread magazziniere = new Thread(new Magazziniere(this));
        magazziniere.setDaemon(true);
        magazziniere.start();

        for(Thread thread: threads)
            thread.join();

        magazziniere.interrupt();
        System.out.println(incasso);

    }
}
