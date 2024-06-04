package Esercitazione03.example;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic extends BankAccount{

    private AtomicInteger balance;

    public BankAccountAtomic(int amount){
        super(amount);
        this.balance = new AtomicInteger(amount);
    }

    @Override
    public void add(int amount){
        balance.addAndGet(amount);
    }

    @Override
    public void withdraw(int amount){
        balance.addAndGet( - amount);
    }

    public int getBalance(){
        return balance.get();
    }
}
