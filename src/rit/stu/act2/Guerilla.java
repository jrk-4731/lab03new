package rit.stu.act2;

public class Guerilla implements Player{

    public static final int CHANCE_TO_BEAT_SOLDIER=20;
    private int id;

    public Guerilla(int id){
        this.id=id;
    }

    public void victory(Player player){
        System.out.println(this+"yells, 'Victoria sobre "+player+"!'");
    }

    public void defeat(Player player){
        System.out.println(this+"yells, 'Derrotado por "+player+"!'");
    }

    @Override
    public String toString(){
        return "Guerilla #"+this.id;
    }
}
