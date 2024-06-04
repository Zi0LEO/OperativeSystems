package Esercitazione03.Esercizio3_1;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static final int ROWS = 30;
    static final int COLUMNS = 50;
    static int[][] matrix = new int[ROWS][COLUMNS];

    public static void main(String[] args) throws InterruptedException {

        final int TIMES = 50000;
        final boolean TO_INCREASE = true;
        AtomicInteger[][] atomicMatrix = new AtomicInteger[ROWS][COLUMNS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++) {
                matrix[i][j] = 0;
                atomicMatrix[i][j] = new AtomicInteger(0);
            }
        }
        printMatrix();


        Thread[] threads = new Thread[ROWS + COLUMNS];
        for(int i = 0; i < COLUMNS; i++){
            ElementModifier em = new ElementModifierAtomic(i, atomicMatrix, TIMES, TO_INCREASE, ROWS);
            Thread thread = new Thread(em);
            thread.start();
            threads[i] = thread;
        }

        for(int i = 0; i < ROWS; i++){
            ElementModifier em2 = new ElementModifierAtomic(i, atomicMatrix, TIMES, !TO_INCREASE, COLUMNS);
            Thread thread = new Thread(em2);
            thread.start();
            threads[COLUMNS + i] = thread;
        }

        for(Thread t: threads)
            t.join();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++)
                matrix[i][j] = atomicMatrix[i][j].get();
        }
        printMatrix();



    }

    public static void printMatrix() {
        for (int i = 0; i < ROWS; i++) {
            System.out.print("[ ");
            for (int j = 0; j < COLUMNS; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("]");
        }
        System.out.println();
        System.out.println();
    }

}
