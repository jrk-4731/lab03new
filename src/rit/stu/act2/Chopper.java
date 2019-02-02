package rit.stu.act2;

import rit.stu.act1.StackNode;

public class Chopper {

    public static final int MAX_OCCUPANCY=6;

    private StackNode<Player> chopper;
    private int numPassengers;
    private int numRescued;

    public Chopper(){
        this.numPassengers=0;
        this.numRescued=0;
        this.chopper=new StackNode<>();
    }

    public boolean isEmpty(){
        return this.numPassengers==0;
    }

    public boolean isFull(){
        return this.numPassengers==MAX_OCCUPANCY;
    }

    public int getNumRescued(){
        return this.numRescued;
    }

    public void rescuePassengers(){
        while(!this.isEmpty()){
            Player rescued=this.chopper.pop();
            this.numPassengers--;
            System.out.println("Chopper transported "+rescued+
                    " to safety!");
            this.numRescued++;
            }
    }

    public void boardPassenger(Player player){
        if (this.isFull()){
            this.rescuePassengers();
        }
            this.chopper.push(player);
            this.numPassengers++;
            System.out.println(player+ " boards the chopper!");
    }

    public static void test_chopper(Chopper chopper){
        System.out.println("Testing isEmpty "+(chopper.isEmpty() ? "OK" :
                "FAIL, got "+false));
        System.out.println("Testing boardPassenger on empty chopper...should " +
                "call rescuePassengers in the process...");
        for (int i=1; i<=MAX_OCCUPANCY+1; i++){
            chopper.boardPassenger(new Hostage(i));
        }
        int rescued=chopper.getNumRescued();
        boolean not_empty=chopper.isEmpty();
        System.out.println((rescued==6 && !not_empty) ?
                "OK": "FAIL, got "+rescued+" and "+ not_empty+" for number " +
                "rescued and if the chopper is empty, respectively.");
    }

    public static void main(String[] args){
        Chopper chopper=new Chopper();
        test_chopper(chopper);
    }
}
