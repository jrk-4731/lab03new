package rit.stu.act2;

/**
 * The class to represent a guerrilla player; implements the player interface.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Guerrilla implements Player{

    /**The number the die roll must not exceed for victory for the Guerrilla
     * against a Soldier object*/
    public static final int CHANCE_TO_BEAT_SOLDIER=20;

    /**The id of the guerrilla*/
    private int id;

    /**
     * The constructor to create a new Guerrilla object.
     *
     * @param id The id of the new Guerrilla object.
     */
    public Guerrilla(int id){
        this.id=id;
    }

    /**
     * Called if the guerrilla is victorious over the soldier.
     *
     * @param player The player object the guerrilla has victory over.
     */
    public void victory(Player player){
        System.out.println(this+" yells, 'Victoria sobre "+player+"!'");
    }

    /**
     * Called if the guerrilla is defeated by the soldier.
     *
     * @param player The player object the guerrilla has been defeated by.
     */
    public void defeat(Player player){
        System.out.println(this+" yells, 'Derrotado por "+player+"!'");
    }

    /**
     * Overrides the toString method of the Object class to represent a
     * guerrilla object as a string.
     *
     * @return The string representation of the guerrilla object.
     */
    @Override
    public String toString(){
        return "Guerrilla #"+this.id;
    }
}
