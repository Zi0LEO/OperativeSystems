package classicProblems.ProducerConsumer;

import java.util.LinkedList;

public class BufferFIFO extends BufferLC {

  protected LinkedList<Thread> producerQueue = new LinkedList<>();
  protected LinkedList<Thread> consumerQueue = new LinkedList<>();

  public BufferFIFO(int dimension) {
    super(dimension);
  }

  @Override
  public void put(int i) throws InterruptedException {
    lock.lock();
    producerQueue.add(Thread.currentThread());
    try {
      while (!canPut()) isFull.await();
      producerQueue.remove();
      buffer[in] = i;
      in = (in + 1) % buffer.length;
      elementsNumber++;
      isEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public int get() throws InterruptedException {
    lock.lock();
    int ret;
    consumerQueue.add(Thread.currentThread());
    try {
      while (!canGet()) isEmpty.await();
      consumerQueue.remove();
      ret = buffer[out];
      out = (out + 1) % buffer.length;
      elementsNumber--;
      isFull.signalAll();
    } finally {
      lock.unlock();
    }
    return ret;
  }

  private boolean canPut() {
    return (elementsNumber < buffer.length) && (Thread.currentThread() == producerQueue.getFirst());
  }

  private boolean canGet() {
    return (elementsNumber > 0) && (Thread.currentThread() == consumerQueue.getFirst());
  }
}
