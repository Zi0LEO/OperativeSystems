package ClassicProblems.ProducerConsumer;

import java.util.LinkedList;

public class BufferID extends BufferFIFO{


    public BufferID(int dimension) {
        super(dimension);
    }

    @Override
    public void put(int i) throws InterruptedException {
        lock.lock();
        producerQueue.add(Thread.currentThread());
        try{
            while(!canPut())
                isFull.await();
            producerQueue.remove();
            buffer[in] = i;
            in = (in + 1) % buffer.length;
            elementsNumber++;
            isEmpty.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public int get() throws InterruptedException{
        int ret;
        lock.lock();
        consumerQueue.add(Thread.currentThread());
        try{
            while(!canGet())
                isEmpty.await();
            consumerQueue.remove();
            ret = buffer[out];
            out = (out + 1) % buffer.length;
            elementsNumber--;
            isFull.signalAll();
        }finally{
            lock.unlock();
        }
        return ret;
    }


    private boolean canPut(){
        long minId;
        if(elementsNumber < buffer.length) {
            minId = searchMinId(producerQueue);
            return Thread.currentThread().getId() == minId;
        }
        return false;
    }

    private boolean canGet() {
        long minId;
        if (elementsNumber > 0  ) {
            minId = searchMinId(consumerQueue);
            return Thread.currentThread().getId() == minId;
        }
        return false;
    }

    private long searchMinId(LinkedList<Thread> queue){
        long id = Long.MAX_VALUE;
        for(Thread thread: queue)
            if(thread.getId() < id)
                id = thread.getId();
        return id;

    }
}
