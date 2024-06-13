package EserciziEsame.Visualizzatore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueLock extends ExerciseQueue{

    protected Lock lock = new ReentrantLock();
    protected Condition isFull = lock.newCondition();
    protected Condition isEmpty = lock.newCondition();

    @Override
    public void inserisciStringa(String string) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() >= 100)
                isFull.await();
            queue.add(string);
            isEmpty.signal();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public String rimuoviStringa() throws InterruptedException {
        lock.lock();
        String string = null;
        try{
            while(queue.size() <= 0)
                isEmpty.await();
            string = queue.pop();
            isFull.signal();
        }finally{
            lock.unlock();
        }
        return string;
    }
}
