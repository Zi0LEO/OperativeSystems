package ClassicProblems.FivePhilosophers;

import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{

    private final Table table;
    private final int index;

    public Philosopher(int index, Table table){
        this.index = index;
        this.table = table;
    }

    @Override
    public void run() {
        try{
            while(true){
                table.takeSticks(index);

                System.out.format("Philosopher %d is eating \n", index);
                eat();

                table.leaveSticks(index);
                System.out.format("Philosopher %d is thinking \n", index);
                think();
            }
        }catch(InterruptedException ignored){}
    }
    private void eat() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    private void think() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
}
