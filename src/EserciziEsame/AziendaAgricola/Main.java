package EserciziEsame.AziendaAgricola;

public class Main {

    public static void main(String[] args) {
        AziendaAgricola azienda = new AziendaAgricolaSemafori();
        try {
            azienda.test(100);
        }catch(InterruptedException ignored){}
    }
}
