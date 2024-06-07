package ClassicProblems.ReadersWriters;

import java.util.concurrent.Semaphore;

public class BookSemaphores extends Book{

    private int readersNumber;
    Semaphore mutex = new Semaphore(1); //ensures only 1 writer at a time can write and
                                                // that book is either read or written at a time

    Semaphore reading = new Semaphore(1); //ensures mutex on readersNumber variable;

    public BookSemaphores(){
        readersNumber = 0;
    }

    @Override
    public void startWriting() throws InterruptedException {
        mutex.acquire();
    }

    @Override
    public void stopWriting() {
        mutex.release();
    }

    @Override
    public void startReading() throws InterruptedException {
        reading.acquire();
        if(readersNumber == 0)
            mutex.acquire();
        readersNumber++;
        reading.release();
    }

    @Override
    public void stopReading() throws InterruptedException {
        reading.acquire();
        if(readersNumber == 1)
            mutex.release();
        readersNumber--;
        reading.release();
    }
}
