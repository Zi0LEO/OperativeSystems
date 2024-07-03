package Esercitazione03.example;

public class BankAccountTest {

  public static void main(String[] args) throws InterruptedException {
    final int STARTING_AMOUNT = 100_000;
    BankAccount account = new BankAccountLC(STARTING_AMOUNT);
    int customersNumber = 200;
    int amount = 100;
    int operationsNumber = 5000;

    startTest(account, customersNumber, amount, operationsNumber);
    System.out.println(
        "Starting balance: " + STARTING_AMOUNT + ", current balance: " + account.getBalance());
    System.out.println("Difference: " + (STARTING_AMOUNT - account.getBalance()));
  }

  private static void startTest(
      BankAccount account, int customersNumber, int amount, int operationsNumber)
      throws InterruptedException {
    Thread[] customers = new Thread[customersNumber];
    for (int i = 0; i < customersNumber; i++) {
      BankCustomer customer = new BankCustomer(amount, operationsNumber, account);
      Thread customerThread = new Thread(customer);
      customerThread.start();
      customers[i] = customerThread;
    }

    for (int i = 0; i < customersNumber; i++) {
      customers[i].join();
    }
  }
}
