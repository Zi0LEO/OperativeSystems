package Esercitazione03;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Thread test = new Test();

    test.start();
    for (int i = 0; i < 12; i++) {
      System.out.println("main: " + test.getState());
      Thread.sleep(1000);
    }
  }
}
