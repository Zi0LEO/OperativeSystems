package eserciziEsame.Visualizzatore;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean correctValue = false;
    ExerciseQueue queue = null;

    while (!correctValue) {
      System.out.println("Selezionare:\n 1 - Esecuzione con semafori \n 2 - Esecuzione con lock");

      String input = in.nextLine();
      switch (input) {
        case "1":
          queue = new QueueSem();
          correctValue = true;
          break;
        case "2":
          queue = new QueueLock();
          correctValue = true;
          break;
        default:
          System.out.println("Valore non corretto, riprova");
      }
    }

    try {
      queue.test();
    } catch (NullPointerException npe) {
      System.out.println("Complimenti, non so come hai fatto a romeprlo");
    }
  }
}
