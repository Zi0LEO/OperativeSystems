package Esercitazione03.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountLC extends BankAccount{

    Lock lock = new ReentrantLock();

    public BankAccountLC(int balance){
        super(balance);
    }

    @Override
    public void add(int amount) {
        lock.lock();
        try {
            balance += amount;
        }finally{
            lock.unlock();
        }
    }

    @Override
    public void withdraw(int amount) {
        lock.lock();
        try{
            balance -= amount;
        }finally{
            lock.unlock();
        }
    }
}
