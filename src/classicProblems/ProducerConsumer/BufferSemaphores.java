package classicProblems.ProducerConsumer;

import java.util.concurrent.Semaphore;

public class BufferSemaphores extends Buffer {

  Semaphore availablePlaces;
  Semaphore presentElements = new Semaphore(0);
  Semaphore mutex = new Semaphore(1);

  public BufferSemaphores(int dimension) {
    super(dimension);
    availablePlaces = new Semaphore(dimension);
  }

  @Override
  public void put(int i) throws InterruptedException {
    availablePlaces.acquire();
    mutex.acquire();
    buffer[in] = i;
    in = (in + 1) % buffer.length;
    mutex.release();
    presentElements.release();
  }

  @Override
  public int get() throws InterruptedException {
    presentElements.acquire();
    mutex.acquire();
    int ret = buffer[out];
    out = (out + 1) % buffer.length;
    mutex.release();
    availablePlaces.release();
    return ret;
  }
}
