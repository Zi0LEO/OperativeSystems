package Esercitazione03.Esercizio3_1;

public abstract class ElementModifier implements Runnable{

    protected int index;
    protected int times;
    protected boolean toIncrease;
    protected int length;

    public ElementModifier(int index, int times, boolean toIncrease, int length){
        this.index = index;
        this.times = times;
        this.toIncrease = toIncrease;
        this.length = length;
    }

    @Override
    public abstract void run();

}
