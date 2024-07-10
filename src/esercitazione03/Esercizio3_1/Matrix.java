package esercitazione03.Esercizio3_1;

public abstract class Matrix {

  public abstract void increment(int row, int column);

  public abstract void decrement(int row, int column);

  public abstract int get(int row, int column);

  public abstract int getRows();

  public abstract int getColumns();
}
