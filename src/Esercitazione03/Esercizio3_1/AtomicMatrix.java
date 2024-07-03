package Esercitazione03.Esercizio3_1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMatrix extends Matrix {

  AtomicInteger[][] atomicMatrix;

  public AtomicMatrix(int rows, int columns) {
    atomicMatrix = new AtomicInteger[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) atomicMatrix[i][j] = new AtomicInteger(0);
    }
  }

  @Override
  public void increment(int row, int column) {
    atomicMatrix[row][column].incrementAndGet();
  }

  @Override
  public void decrement(int row, int column) {
    atomicMatrix[row][column].decrementAndGet();
  }

  @Override
  public int get(int row, int column) {
    return atomicMatrix[row][column].get();
  }

  @Override
  public int getRows() {
    return atomicMatrix.length;
  }

  @Override
  public int getColumns() {
    return atomicMatrix[0].length;
  }
}
