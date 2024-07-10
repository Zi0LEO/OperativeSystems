package esercitazione03.Esercizio3_1;

public class ElementModifier implements Runnable {

  protected int index;
  protected int times;
  protected boolean toIncrease;
  protected int length;
  protected Matrix matrix;

  public ElementModifier(int index, int times, boolean toIncrease, int length, Matrix matrix) {
    this.index = index;
    this.times = times;
    this.toIncrease = toIncrease;
    this.length = length;
    this.matrix = matrix;
  }

  @Override
  public void run() {
    for (int t = 0; t < times; t++) {
      for (int i = 0; i < this.length; i++) {
        if (toIncrease) {
          matrix.increment(i, index);
        } else {
          matrix.decrement(index, i);
        }
      }
    }
  }
}
