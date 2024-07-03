package EserciziEsame.BarMod;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Bar bar = new BarSemaphores();
        Thread[] threads = new Thread[100];

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Cliente(bar, i));
            threads[i].start();
        }

        for(int i = 0; i < 100; i++)
            threads[i].join();

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(TimeUnit.MILLISECONDS.toMinutes(time));

    }
}
