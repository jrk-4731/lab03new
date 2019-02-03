package rit.stu.act2;

/**
 * The class to represent the predator; implements the player interface.
 */
public class Predator implements Player{

    /**The number the die roll must not exceed to defeat the hostage.*/
    public static final int CHANCE_TO_BEAT_HOSTAGE=75;

    /**The number the die roll must not exceed to defeat the soldier.*/
    public static final int CHANCE_TO_BEAT_SOLDIER=50;

    /**
     * The constructor for the predator object.
     */
    public Predator(){

    }

    /**
     * Called if the predator defeats a player.
     *
     * @param player The player object that was defeated.
     */
    public void victory(Player player){
        System.out.println("The predator yells out in triumphant victory over "+
                player);
    }

    /**
     * Called if the predator is defeated.
     *
     * @param player The player object that was victorious.
     */
    public void defeat(Player player){
        System.out.println("The predator cries out in glorious defeat to "+
                player);
    }

    /**
     * Overrides the toString method in the Object class to create the string
     * representation for the predator.
     *
     * @return The string representation of the predator.
     */
    @Override
    public String toString(){
        return "Predator";
    }



}
