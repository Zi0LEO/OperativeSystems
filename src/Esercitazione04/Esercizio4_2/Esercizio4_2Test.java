package Esercitazione04.Esercizio4_2;


import java.util.concurrent.Semaphore;

public class Esercizio4_2Test {

    static Semaphore sync = new Semaphore(0);

    static class APrinter extends Thread{

        public void run(){
            System.out.print("A");
            sync.release();
        }
    }
    static class BPrinter extends Thread{

        public void run(){
            try {
                sync.acquire();
                System.out.print("B ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)  {

        for(;;) {
            new BPrinter().start();
            new APrinter().start();
            try {
                Thread.sleep(1000);
            }catch(InterruptedException ignored){}
        }
    }
}
