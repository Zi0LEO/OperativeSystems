package Esercitazione03.example;

public abstract class BankAccount {

  protected int balance;

  public BankAccount(int balance) {
    this.balance = balance;
  }

  public abstract void add(int amount);

  public abstract void withdraw(int amount);

  public int getBalance() {
    return balance;
  }
}
