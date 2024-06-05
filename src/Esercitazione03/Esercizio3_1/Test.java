package Esercitazione03.Esercizio3_1;

import java.util.Scanner;

public class Test {
    static final int ROWS = 30;
    static final int COLUMNS = 50;
    public enum ExecutionType{
        THREAD_SAFE,
        NON_THREAD_SAFE
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        boolean correctValue = false;
        ExecutionType executionType = null;

        while(!correctValue) {
            System.out.println("Select execution type:\n 1 - Thread-Safe \n 2 - Non Thread-Safe");

            String input = in.nextLine();
            switch (input) {
                case "1":
                    executionType = ExecutionType.THREAD_SAFE;
                    correctValue = true;
                    break;
                case "2":
                    correctValue = true;
                    executionType = ExecutionType.NON_THREAD_SAFE;
                    break;
                default:
                    System.out.println("Incorrect value");
            }
        }


        final int TIMES = 500000;
        final boolean TO_INCREASE = true;
        Matrix matrix = (executionType == ExecutionType.THREAD_SAFE) ? new AtomicMatrix(ROWS, COLUMNS) : new IntMatrix(ROWS,COLUMNS);

        printMatrix(matrix);

        long start = System.nanoTime();

        Thread[] threads = new Thread[ROWS + COLUMNS];
        for(int i = 0; i < COLUMNS; i++){
            ElementModifier em = new ElementModifier(i, TIMES, TO_INCREASE, ROWS, matrix);
            Thread thread = new Thread(em);
            thread.start();
            threads[i] = thread;
        }

        for(int i = 0; i < ROWS; i++){
            ElementModifier em2 = new ElementModifier(i, TIMES, !TO_INCREASE, COLUMNS, matrix);
            Thread thread = new Thread(em2);
            thread.start();
            threads[COLUMNS + i] = thread;
        }

        for(Thread t: threads)
            t.join();

        long end = System.nanoTime();

        printMatrix(matrix);


        System.out.println("Needed time: " + (end - start) / 1_000_000);

    }

    public static void printMatrix(Matrix matrix) {
        for (int i = 0; i < ROWS; i++) {
            System.out.print("[ ");
            for (int j = 0; j < COLUMNS; j++)
                System.out.print(matrix.get(i,j) + " ");
            System.out.println("]");
        }
        System.out.println();
        System.out.println();
    }
}
