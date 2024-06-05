package Esercitazione04.Esercizio4_1;

import java.util.concurrent.Semaphore;

public class MutexTest {

    static Semaphore mutex = new Semaphore(1);

    static class APrinter extends Thread{

        public void run(){
            try {
                mutex.acquire();
                System.out.println("A");
                mutex.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class BPrinter extends Thread{

        public void run(){
            try {
                mutex.acquire();
                System.out.println("B");
                mutex.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        new APrinter().start();
        new BPrinter().start();

    }
}
