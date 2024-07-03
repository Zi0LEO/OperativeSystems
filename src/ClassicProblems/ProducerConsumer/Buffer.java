package ClassicProblems.ProducerConsumer;

public abstract class Buffer {

  protected int[] buffer;
  protected int in;
  protected int out;

  public Buffer(int dimension) {
    buffer = new int[dimension];
    int in = 0;
    int out = 0;
  }

  public abstract void put(int i) throws InterruptedException;

  public abstract int get() throws InterruptedException;

  public void test(int numProducers, int numConsumers) {
    for (int i = 0; i < numProducers; i++) new Thread(new Producer(this)).start();
    for (int i = 0; i < numConsumers; i++) new Thread(new Consumer(this)).start();
  }
}
