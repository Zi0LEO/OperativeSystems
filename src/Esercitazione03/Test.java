package Esercitazione03;

public class Test extends Thread{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getState());
        do {
            try {
                Thread.sleep(1000);
                System.out.println(" aaaa");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(true);

    }
}
