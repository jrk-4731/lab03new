package rit.stu.act2;

import rit.stu.act1.QueueNode;

public class Bunker {

    private QueueNode<Soldier> bunker;
    private int numSoldiers;

    public Bunker(int numSoldiers){
        this.numSoldiers=numSoldiers;
        this.bunker=new QueueNode<>();
        for (int i=1; i<=numSoldiers; i++){
            this.bunker.enqueue(new Soldier(i));
        }
    }

    public boolean hasSoldiers(){
        return !this.bunker.empty();
    }

    public int getNumSoldiers(){
        return this.numSoldiers;
    }

    public Soldier deployNextSolider(){
        assert !this.bunker.empty();
        return this.bunker.dequeue();
    }

    public void fortifySoldiers(Soldier soldier){
        this.bunker.enqueue(soldier);
    }

    public void testBunker(){

    }

    public static void main(String[] args){

    }


}
