package Esercitazione03.Esercizio3_1;

import java.util.concurrent.atomic.AtomicInteger;

public class ElementModifierAtomic extends ElementModifier{

    protected AtomicInteger[][] atomicMatrix;

    public ElementModifierAtomic(int index, AtomicInteger[][] matrix, int times, boolean toIncrease, int length){
        super(index, times, toIncrease, length);
        this.atomicMatrix = matrix;
    }

    @Override
    public void run() {
        for(int t = 0; t < times; t++) {
            for (int i = 0; i < this.length; i++) {
                if (toIncrease) {
                    atomicMatrix[i][index].incrementAndGet();
                }
                else {
                    atomicMatrix[index][i].decrementAndGet();

                }
            }
        }
    }
}
