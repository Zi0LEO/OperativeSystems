package Esercitazione04.Esercizio4_1;

import java.util.concurrent.Semaphore;
import java.util.function.BiPredicate;

public class SyncTest {

    static Semaphore sync = new Semaphore(0);

    static class APrinter extends Thread{

        static final int TIMES = 10;

        public void run(){
            for(int i = 0; i < TIMES; i++) {
                System.out.println("A");
                sync.release();
            }
        }
    }
    static class BPrinter extends Thread{

        static final int TIMES = 10;

        public void run(){
            for(int i = 0; i < TIMES; i++) {
                try {
                    sync.acquire();
                    System.out.println("B");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        new APrinter().start();
        new BPrinter().start();
    }
}
