package rit.stu.act2;

public class Hostage implements Player{

    private int id;

    public Hostage(int id){
        this.id=id;
    }

    public void victory(Player player){
        System.out.println(this+"yells, 'Victory over "+ player+"!'");
    }
    public void defeat(Player player){
        System.out.println(this+"yells, 'Defeated by "+ player + "!'");
    }

    @Override
    public String toString(){
        return "Hostage #"+this.id;
    }
}
