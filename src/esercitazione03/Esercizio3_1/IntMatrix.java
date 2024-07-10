package esercitazione03.Esercizio3_1;

public class IntMatrix extends Matrix {

  public int[][] intMatrix;

  public IntMatrix(int rows, int columns) {
    intMatrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) intMatrix[i][j] = 0;
    }
  }

  @Override
  public void increment(int row, int column) {
    intMatrix[row][column]++;
  }

  @Override
  public void decrement(int row, int column) {
    intMatrix[row][column]--;
  }

  @Override
  public int get(int row, int column) {
    return intMatrix[row][column];
  }

  @Override
  public int getRows() {
    return intMatrix.length;
  }

  @Override
  public int getColumns() {
    return intMatrix[0].length;
  }
}
