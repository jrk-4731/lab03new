package rit.stu.act2;

/**
 * The class to represent a hostage player; implements the player interface.
 *
 * @author Jake Koerner<jrk4731@g.rit.edu>
 */
public class Hostage implements Player{

    /**The id of the hostage*/
    private int id;

    /**
     * The constructor for a hostage object.
     *
     * @param id The id of the new hostage object.
     */
    public Hostage(int id){
        this.id=id;
    }

    /**
     * Called if the hostage defeats the predator.
     *
     * @param player The player object the hostage defeated.
     */
    public void victory(Player player){
        System.out.println(this+" yells, 'Victory over "+ player+"!'");
    }

    /**
     * Called if the hostage is defeated by the predator.
     *
     * @param player The player object the hostage is defeated by.
     */
    public void defeat(Player player){
        System.out.println(this+" yells, 'Defeated by "+ player + "!'");
    }

    /**
     * Overrides the toString method of the Object class to create a string
     * representation of a hostage object.
     *
     * @return The string representation of a hostage object.
     */
    @Override
    public String toString(){
        return "Hostage #"+this.id;
    }
}
