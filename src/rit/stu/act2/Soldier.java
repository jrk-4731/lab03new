package rit.stu.act2;

/**
 * The class for the soldier object; implements the player interface.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Soldier implements Player {

    /**The id of the soldier*/
    private int id;

    /**
     * The constructor for a soldier object.
     *
     * @param id The id of the soldier.
     */
    public Soldier(int id){
        this.id=id;
    }

    /**
     * Called if the soldier is victorious over the player.
     *
     * @param player The player object that was defeated.
     */
    public void victory(Player player){
        System.out.println(this+" cries, 'Sieg uber "+player+"!'");
    }

    /**
     * Called if the soldier is defeated by the player.
     *
     * @param player The player object that was victorious.
     */
    public void defeat(Player player){
        System.out.println((this+" cries, 'Besiegt von "+player+"!'"));
    }

    /**
     * Overrides the toString method of the Object class to create a string
     * representation for the soldier object.
     *
     * @return The string representation for the soldier object.
     */
    @Override
    public String toString(){
        return "Soldier #"+this.id;
    }
}
