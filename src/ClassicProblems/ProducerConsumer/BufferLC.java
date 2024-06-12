package ClassicProblems.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferLC extends Buffer{

    protected  int elementsNumber = 0;
    protected final Lock lock = new ReentrantLock();
    protected final Condition isEmpty = lock.newCondition();
    protected final Condition isFull = lock.newCondition();

    public BufferLC(int dimension) {
        super(dimension);
    }

    @Override
    public void put(int i) throws InterruptedException {
        lock.lock();
        try{
            while(elementsNumber == buffer.length)
                isFull.await();
            buffer[in] = i;
            in = (in + 1) % buffer.length;
            elementsNumber++;
            isEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int get() throws InterruptedException {
        int ret;
        lock.lock();
        try{
            while(elementsNumber == 0)
                isEmpty.await();
            ret = buffer[out];
            out = (out + 1) % buffer.length;
            elementsNumber--;
            isFull.signal();
        }finally {
            lock.unlock();
        }
        return ret;
    }
}
