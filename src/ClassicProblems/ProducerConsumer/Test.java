package ClassicProblems.ProducerConsumer;

public class Test {
    public static void main(String[] args) {
        Buffer buffer =  new BufferSemaphores(10);
        buffer.test(10,10);
    }
}
