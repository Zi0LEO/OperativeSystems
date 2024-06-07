package ClassicProblems.ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{

    protected Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try{
            while(true){
                int object = buffer.get();
                consume(object);
            }
        }catch(InterruptedException ignored){}
    }

    private void consume(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        }catch(InterruptedException ignored){}
    }
}
