package rit.stu.act2;

import rit.stu.act1.QueueNode;
import rit.stu.act1.StackNode;

public class EnemyBase {

    private StackNode<Hostage> hostages;
    private QueueNode<Guerilla> guerillas;
    private int numHostages;
    private int numGuerillas;

    public EnemyBase(int numHostages, int numGuerillas){
        this.hostages=new StackNode<>();
        this.guerillas=new QueueNode<>();
        for (int i=1; i<=numHostages; i++){
            this.addHostage(new Hostage(i));
        }
        for (int i=1; i<=numGuerillas; i++){
            this.addGuerilla(new Guerilla(i));
        }
    }

    private void addGuerilla(Guerilla guerilla){
        this.guerillas.enqueue(guerilla);
        this.numGuerillas++;
    }

    private void addHostage(Hostage hostage){
       this.hostages.push(hostage);
       this.numHostages++;
    }

    private Guerilla getGuerilla(){
        this.numGuerillas--;
        return this.guerillas.dequeue();
    }

    private Hostage getHostage(){
        this.numHostages--;
        return this.hostages.pop();
    }

    public int getNumHostages(){
        return this.numHostages;
    }
    public int getNumGuerillas(){
        return this.numGuerillas;
    }

    public Hostage rescueHostage(Soldier soldier){
        System.out.println(soldier+ " enters enemy base...");
        Hostage to_rescue=this.getHostage();
        if (to_rescue==null){
            System.out.println("No more hostages!");
            return to_rescue;
        }
        if (this.getNumGuerillas()!=0){
          Guerilla to_battle=this.getGuerilla();
          int die_roll=Battlefield.nextInt(1, 100);
          System.out.println(soldier+ " battles "+to_battle+" who rolls a "
                  + die_roll);
          if (die_roll> Guerilla.CHANCE_TO_BEAT_SOLDIER){
              soldier.victory(to_battle);
              to_battle.defeat(soldier);
              return to_rescue;
          }
          else{
              soldier.defeat(to_battle);
              to_battle.victory(soldier);
              this.addHostage(to_rescue);
              this.addGuerilla(to_battle);
              return null;
          }
        }
        else{
            return to_rescue;
        }
    }

    public static void test_base(EnemyBase base, Hostage hostage,
                                 Guerilla guerilla, Soldier soldier){
        base.addGuerilla(guerilla);
        int more_guerillas=base.getNumGuerillas();
        System.out.println("Testing addGuerilla "+(more_guerillas==11 ?
                "OK": "FAIL, got "+more_guerillas));
        base.addHostage(hostage);
        int more_hostages=base.getNumHostages();
        System.out.println("Testing addHostage "+(more_hostages==21 ? "OK":
                "FAIL, got "+more_hostages));
        System.out.println("Testing getGuerilla...");
        Guerilla new_guerilla=base.getGuerilla();
        int norm_num_guerillas=base.getNumGuerillas();
        System.out.println(norm_num_guerillas==10 ? "OK": "FAIL, got "+
                norm_num_guerillas);
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

    public static void main(String[] args){
        EnemyBase base=new EnemyBase(20, 10);
        Hostage new_hostage=new Hostage(50);
        Guerilla new_guerilla=new Guerilla(50);
        Soldier new_soldier=new Soldier(50);
        test_base(base, new_hostage, new_guerilla, new_soldier);
    }
}
