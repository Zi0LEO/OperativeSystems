package Esercitazione03.example;

import java.util.concurrent.Semaphore;

public class BankAccountSemaphores extends BankAccount {

    Semaphore mutex = new Semaphore(1);

    public BankAccountSemaphores(int balance){
        super(balance);
    }

    @Override
    public void add(int amount) {
        try{
            mutex.acquire();
            balance += amount;
            mutex.release();
        }catch(InterruptedException ie){}
    }

    @Override
    public void withdraw(int amount) {
        try{
            mutex.acquire();
            balance -= amount;
            mutex.release();
        }catch(InterruptedException ie){}
    }
}
