package rit.stu.act2;

public class Soldier implements Player {

    private int id;

    public Soldier(int id){
        this.id=id;
    }

    public void victory(Player player){
        System.out.println(this+"cries, 'Sieg uber "+player+"!'");
    }

    public void defeat(Player player){
        System.out.println((this+"cries, 'Besiegt von "+player+"!'"));
    }

    @Override
    public String toString(){
        return "Soldier #"+this.id;
    }
}
