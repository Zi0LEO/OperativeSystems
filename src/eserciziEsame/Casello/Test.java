package EserciziEsame.Casello;

import java.util.Scanner;

public class Test {

  static final int TARIFFA = 5;
  static final int PORTE = 10;
  static final int VEICOLI = 50;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean correctValue = false;
    Casello casello = null;

    while (!correctValue) {
      System.out.println("Selezionare:\n 1 - Esecuzione con semafori \n 2 - Esecuzione con lock");

      String input = in.nextLine();
      switch (input) {
        case "1":
          casello = new CaselloSem(PORTE, TARIFFA);
          correctValue = true;
          break;
        case "2":
          casello = new CaselloLock(PORTE, TARIFFA);
          correctValue = true;
          break;
        default:
          System.out.println("Valore non corretto, riprova");
      }
    }

    try {
      casello.test(VEICOLI);
    } catch (InterruptedException ignored) {
    } catch (NullPointerException npe) {
      System.out.println("Complimenti, non so come hai fatto a romeprlo");
    }
  }
}
