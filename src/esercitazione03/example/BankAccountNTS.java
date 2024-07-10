package esercitazione03.example;

public class BankAccountNTS extends BankAccount {

  public BankAccountNTS(int amount) {
    super(amount);
  }

  @Override
  public void add(int amount) {
    super.balance += amount;
  }

  @Override
  public void withdraw(int amount) {
    super.balance -= amount;
  }
}
