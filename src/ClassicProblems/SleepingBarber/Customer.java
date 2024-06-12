package ClassicProblems.SleepingBarber;

public class Customer implements Runnable{

    private final BarberHall hall;
    private final int id;

    public Customer(BarberHall hall, int id){
        this.hall = hall;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            try{
                //System.out.format("Customer %d wants to cut his hair \n", id);
                boolean canCut = hall.waitForCut();
                if(canCut)
                    System.out.format("Customer %d managed to cut his hair \n", id);
                //else
                    //System.out.format("Customer %d went away \n", id);
            } catch (InterruptedException ie) {
                System.out.println("Exception in customer " + id);
            }
        }

    }
}
