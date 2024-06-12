package ClassicProblems.SleepingBarber;

import java.util.concurrent.Semaphore;

public class BarberHallSemaphores extends BarberHall{

    Semaphore mutex = new Semaphore(1);
    Semaphore cuttingChair = new Semaphore(0, true);
    Semaphore availableClient = new Semaphore(0, true);

    public BarberHallSemaphores(int chairsNumber) {
        super(chairsNumber);
    }


    @Override
    public void cutHair() throws InterruptedException {
        availableClient.acquire();
        cuttingChair.release();
    }

    @Override
    public boolean waitForCut() throws InterruptedException {
        mutex.acquire();
        if(availableChairs == 0){
            mutex.release();
            return false;
        }
        availableChairs--;
        mutex.release();
        availableClient.release();
        cuttingChair.acquire();
        mutex.acquire();
        availableChairs++;
        mutex.release();
        return true;
    }
}
