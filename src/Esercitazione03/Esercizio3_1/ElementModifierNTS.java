package Esercitazione03.Esercizio3_1;

public class ElementModifierNTS extends ElementModifier{

    protected int[][] matrix;
    public ElementModifierNTS(int index, int[][] matrix, int times, boolean toIncrease, int length){
        super(index, times, toIncrease, length);
        this.matrix = matrix;
    }
    @Override
    public void run() {
        for(int t = 0; t < times; t++) {
            for (int i = 0; i < this.length; i++){
                if(toIncrease)
                    matrix[i][index]++;
                else
                    matrix[index][i]--;
            }


        }
    }
}
