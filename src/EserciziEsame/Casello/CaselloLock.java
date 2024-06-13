package EserciziEsame.Casello;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CaselloLock extends Casello{

    private final LinkedList[] queues = new LinkedList[porte];
    protected final Lock lock = new ReentrantLock();
    protected final Condition myTurn = lock.newCondition();

    public CaselloLock(int porte, int tariffa){
        super(porte, tariffa);
        for(int i = 0; i < porte; i++)
            queues[i] =  new LinkedList<Thread>();
    }


    @Override
    public void mettiInCoda(int porta) throws InterruptedException {
        lock.lock();
        try {
            queues[porta].add(Thread.currentThread());
            while(!(queues[porta].getFirst() == Thread.currentThread()))
                myTurn.await();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public void paga(int chilometriPercorsi) {
        lock.lock();
        try{
            incasso += chilometriPercorsi * tariffa;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void lascia(int porta) {
        lock.lock();
        try{
            queues[porta].removeFirst();
            myTurn.signal();
        }finally {
            lock.unlock();
        }
    }
}
