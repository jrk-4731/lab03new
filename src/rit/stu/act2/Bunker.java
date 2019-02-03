package rit.stu.act2;

import rit.stu.act1.QueueNode;


/**
 * The bunker class used to hold and deploy soldiers for the simulation.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Bunker {

    /**The bunker, using the QueueNode class as its underlying data structure.*/
    private QueueNode<Soldier> bunker;

    /**The number of soldiers in the bunker*/
    private int numSoldiers;

    /**
     * Creates a bunker and fills it with soldiers based on the argument given
     * for the numSoldiers parameter.
     *
     * @param numSoldiers The number of soldiers to fill the bunker with.
     */
    public Bunker(int numSoldiers){
        this.numSoldiers=numSoldiers;
        this.bunker=new QueueNode<>();
        for (int i=1; i<=numSoldiers; i++){
            this.bunker.enqueue(new Soldier(i));
        }
    }

    /**
     * Checks whether or not the bunker contains any soldiers.
     *
     * @return True if the bunker is not empty, false otherwise.
     */
    public boolean hasSoldiers(){
        return !this.bunker.empty();
    }

    /**
     * Returns the number of soldiers within the bunker.
     *
     * @return The number of soldiers in the bunker.
     */
    public int getNumSoldiers(){
        return this.numSoldiers;
    }

    /**
     * Deploys the soldier at the front of the bunker/queue.
     *
     * @return The soldier deployed.
     *
     * Pre-condition: The bunker is not empty.
     */
    public Soldier deployNextSolider(){
        assert !this.bunker.empty();
        this.numSoldiers--;
        return this.bunker.dequeue();
    }

    /**
     * Adds a soldier to the back of the bunker/queue.
     *
     * @param soldier The soldier to add to the bunker.
     */
    public void fortifySoldiers(Soldier soldier){
        this.bunker.enqueue(soldier);
        this.numSoldiers++;
    }

    /**
     * Tester function for the bunker class.
     *
     * @param numSoldiers The number of soldiers to create a new bunker and test
     *                    certain methods.
     * @param new_soldier A soldier used for testing methods.
     */
    public static void testBunker(int numSoldiers, Soldier new_soldier){
        System.out.println("Creating bunker...");
        Bunker bunker=new Bunker(numSoldiers);
        System.out.println("Creating empty bunker to test...");
        Bunker empty_bunker=new Bunker(0);
        boolean everyone_here=bunker.hasSoldiers();
        boolean nobody_here=empty_bunker.hasSoldiers();
        System.out.println("Testing hasSoldiers "+(
                (everyone_here==true && nobody_here==false) ? "OK" :
                        "FAIl, got "+everyone_here+" and "+nobody_here+" for " +
                                "the full and empty bunkers, respectively."));
        int numSoldiers_to_test=bunker.getNumSoldiers();
        System.out.println("Testing getNumSoldiers "+(numSoldiers_to_test
        ==numSoldiers ? "OK" : "FAIL, got "+numSoldiers_to_test));
        System.out.println("Testing deployNextSoldier on empty bunker...");
        try{
            empty_bunker.deployNextSolider();
        }
        catch (AssertionError T){
            System.out.println("OK");
        }
        Soldier depolyed=bunker.deployNextSolider();
        System.out.println("Testing deploySoldier on full bunker "+(
                bunker.getNumSoldiers()<numSoldiers ?
                        "OK" : "FAIL, got "+ depolyed));
        System.out.println("Testing fortifySoldiers on empty bunker...");
        empty_bunker.fortifySoldiers(new_soldier);
        boolean not_empty=empty_bunker.hasSoldiers();
        System.out.println(not_empty==true ? "OK": "FAIL," +
                "got "+not_empty);
        System.out.println("Testing fortifySoldier on full bunker...");
        bunker.fortifySoldiers(new_soldier);
        int back_to_full=bunker.getNumSoldiers();
        System.out.println(back_to_full==numSoldiers ? "OK":
                "FAIL, got "+back_to_full);
        int original_num=bunker.getNumSoldiers()-1;
        for (int i=0; i<original_num; i++){
            bunker.deployNextSolider();
        }
        Soldier last_soldier=bunker.deployNextSolider();
        System.out.println(last_soldier.equals(new_soldier) ?
                "OK" : "FAIL, got "+last_soldier);
    }

    /**
     * Creates a new soldier, and calls the testBunker method.
     *
     * @param args Command line arguments; ignore.
     */
    public static void main(String[] args){
        Soldier new_soldier=new Soldier(50);
        testBunker(40, new_soldier);
    }


}
