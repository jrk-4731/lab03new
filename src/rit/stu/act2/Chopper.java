package rit.stu.act2;

import rit.stu.act1.StackNode;

/**
 * The chopper class used to rescue hostages and soldiers.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Chopper {

    /**The maximum number of player objects that can be boarded on the chopper
     * at a time.*/
    public static final int MAX_OCCUPANCY=6;

    /**The chopper object implemented using the StackNode as the dat structure.*/
    private StackNode<Player> chopper;

    /**The number of passengers currently on the chopper.*/
    private int numPassengers;

    /**The number of passengers the chopper has rescued in total.*/
    private int numRescued;

    /**
     * The chopper constructor, which creates an empty chopper using the
     * StackNode class as the data structure.
     */
    public Chopper(){
        this.numPassengers=0;
        this.numRescued=0;
        this.chopper=new StackNode<>();
    }

    /**
     * Checks if the chopper is empty.
     *
     * @return True if empty; false otherwise.
     */
    public boolean isEmpty(){
        return this.numPassengers==0;
    }

    /**
     * Checks if the chopper is full.
     *
     * @return True if the chopper has six passengers; false otherwise.
     */
    public boolean isFull(){
        return this.numPassengers==MAX_OCCUPANCY;
    }

    /**
     * Returns the total number of passengers rescued.
     *
     * @return The number of passengers rescued.
     */
    public int getNumRescued(){
        return this.numRescued;
    }

    /**
     * Rescues passengers, emptying the chopper.
     *
     * Pre-conditions: The chopper is full or there are no more hostages to
     * rescue.
     * Post-condition: The chopper is empty.
     */
    public void rescuePassengers(){
        while(!this.isEmpty()){
            Player rescued=this.chopper.pop();
            this.numPassengers--;
            System.out.println("Chopper transported "+rescued+
                    " to safety!");
            this.numRescued++;
            }
    }

    /**
     * Boards a given player object onto the chopper.
     *
     * @param player The passenger to board onto the chopper.
     */
    public void boardPassenger(Player player){
        if (this.isFull()){
            this.rescuePassengers();
        }
            this.chopper.push(player);
            this.numPassengers++;
            System.out.println(player+ " boards the chopper!");
    }

    /**
     * The tester function for the chopper class.
     *
     * @param chopper A chopper object to run tests on.
     */
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

    /**
     * Creates an empty chopper object and calls the test_chopper method.
     *
     * @param args Command line arguments; ignore.
     */
    public static void main(String[] args){
        Chopper chopper=new Chopper();
        test_chopper(chopper);
    }
}
