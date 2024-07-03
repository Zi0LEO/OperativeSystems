package Esercitazione03.example;

import java.util.Random;

public class BankCustomer implements Runnable {

  private static final int MIN_WAITING = 1;
  private static final int MAX_WAITING = 3;

  private final Random random = new Random();
  private final int amountOfMoney, numberOfOperations;
  private final BankAccount bankAccount;

  public BankCustomer(int amount, int number, BankAccount ba) {
    if (number % 2 != 0) throw new RuntimeException("Operations must be even.");
    this.amountOfMoney = amount;
    this.numberOfOperations = number;
    this.bankAccount = ba;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < numberOfOperations; i++) {
        randomWait();
        if (i % 2 == 0) bankAccount.add(amountOfMoney);
        else bankAccount.withdraw(amountOfMoney);
      }
    } catch (InterruptedException e) {
    }
    System.out.println("Customer " + Thread.currentThread().getId() + " has ended his operations");
  }

  private void randomWait() throws InterruptedException {
    Thread.sleep((random.nextInt(MAX_WAITING - MIN_WAITING + 1) + MIN_WAITING));
  }
}
