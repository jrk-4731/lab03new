package rit.stu.act2;

import rit.stu.act1.QueueNode;
import rit.stu.act1.StackNode;

/**
 * The enemy base class for holding hostages and guerrillas.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class EnemyBase {

    /**The line of hostages, implemented using a StackNode.*/
    private StackNode<Hostage> hostages;

    /**The line of guerrillas implemented using a Queue*/
    private QueueNode<Guerrilla> guerrillas;

    /**The number of hostages in the base.*/
    private int numHostages;

    /**The number of guerrillas in the base*/
    private int namGuerrillas;

    /**
     * Creates an enemy base and fills in the number of hostages and guerrillas
     * given.
     *
     * @param numHostages The number of hostages to add to the enemy base.
     * @param numGuerrillas The number of guerrillas to add to the enemy base.
     */
    public EnemyBase(int numHostages, int numGuerrillas){
        this.hostages=new StackNode<>();
        this.guerrillas =new QueueNode<>();
        for (int i=1; i<=numHostages; i++){
            this.addHostage(new Hostage(i));
        }
        for (int i=1; i<=numGuerrillas; i++){
            this.addGuerrilla(new Guerrilla(i));
        }
    }

    /**
     * Adds a guerrilla to the queue in the base.
     *
     * @param guerrilla The guerrilla to add to the queue.
     */
    private void addGuerrilla(Guerrilla guerrilla){
        this.guerrillas.enqueue(guerrilla);
        this.namGuerrillas++;
    }

    /**
     * Adds a hostage to the stack in the base.
     *
     * @param hostage The hostage to add to the stack.
     */
    private void addHostage(Hostage hostage){
       this.hostages.push(hostage);
       this.numHostages++;
    }

    /**
     * Returns the guerrilla at the front of the queue.
     *
     * @return The guerrilla at the front of the queue.
     */
    private Guerrilla getGuerrilla(){
        this.namGuerrillas--;
        return this.guerrillas.dequeue();
    }

    /**
     * Returns the hostage at the front of the stack.
     *
     * @return The hostage at the front of the stack.
     */
    private Hostage getHostage(){
        this.numHostages--;
        return this.hostages.pop();
    }

    /**
     * Gets the number of hostages in the base.
     *
     * @return The number of hostages in the base.
     */
    public int getNumHostages(){
        return this.numHostages;
    }

    /**
     * Gets the number of guerrillas in the base.
     *
     * @return The number of guerrillas in the base.
     */
    public int getNamGuerrillas(){
        return this.namGuerrillas;
    }

    /**
     * Sends a soldier to rescue a hostage, and battle a guerrilla to see if the
     * hostage is successfully rescued.
     *
     * @param soldier The soldier to rescue the hostage and battle the guerrilla
     *                at the front of the queue.
     * @return The hostage if the soldier defeats the guerrilla or if there are
     * no more guerrillas in the base to battle; null if the soldier is defeated
     * by the guerrilla.
     */
    public Hostage rescueHostage(Soldier soldier){
        System.out.println(soldier+ " enters enemy base...");
        Hostage to_rescue=this.getHostage();
        if (to_rescue==null){
            System.out.println("No more hostages!");
            return to_rescue;
        }
        if (this.getNamGuerrillas()!=0){
          Guerrilla to_battle=this.getGuerrilla();
          int die_roll=Battlefield.nextInt(1, 100);
          System.out.println(soldier+ " battles "+to_battle+" who rolls a "
                  + die_roll);
          if (die_roll> Guerrilla.CHANCE_TO_BEAT_SOLDIER){
              soldier.victory(to_battle);
              to_battle.defeat(soldier);
              return to_rescue;
          }
          else{
              soldier.defeat(to_battle);
              to_battle.victory(soldier);
              this.addHostage(to_rescue);
              this.addGuerrilla(to_battle);
              return null;
          }
        }
        else{
            return to_rescue;
        }
    }

    /**
     * The tester function for the EnemyBase class.
     *
     * @param base An EnemyBase object to test
     * @param hostage A hostage object to use for testing methods.
     * @param guerrilla A guerrilla object to use for testing methods.
     * @param soldier A soldier object to use for testing methods.
     */
    public static void test_base(EnemyBase base, Hostage hostage,
                                 Guerrilla guerrilla, Soldier soldier){
        base.addGuerrilla(guerrilla);
        int more_guerrillas=base.getNamGuerrillas();
        System.out.println("Testing addGuerrilla "+(more_guerrillas==11 ?
                "OK": "FAIL, got "+more_guerrillas));
        base.addHostage(hostage);
        int more_hostages=base.getNumHostages();
        System.out.println("Testing addHostage "+(more_hostages==21 ? "OK":
                "FAIL, got "+more_hostages));
        System.out.println("Testing getGuerrilla...");
        Guerrilla new_guerrilla=base.getGuerrilla();
        int norm_num_guerrillas=base.getNamGuerrillas();
        System.out.println(norm_num_guerrillas==10 ? "OK": "FAIL, got "+
                norm_num_guerrillas);
        System.out.println("Testing getHostage...");
        Hostage new_hostage=base.getHostage();
        int norm_num_hostages=base.getNumHostages();
        System.out.println(norm_num_hostages==20 ? "OK": "FAIL, got "+
                norm_num_hostages);
        System.out.println("Several Runs of rescueHostage...Does everything " +
                "look right?");
        for (int i=0; i<25; i++){
            System.out.println(base.rescueHostage(soldier));
        }
    }

    /**
     * Creates EnemyBase, hostage, guerrilla and soldier objects to call
     * the test_base method.
     *
     * @param args Command line arguments; ignore.
     */
    public static void main(String[] args){
        EnemyBase base=new EnemyBase(20, 10);
        Hostage new_hostage=new Hostage(50);
        Guerrilla new_guerrilla=new Guerrilla(50);
        Soldier new_soldier=new Soldier(50);
        test_base(base, new_hostage, new_guerrilla, new_soldier);
    }
}
