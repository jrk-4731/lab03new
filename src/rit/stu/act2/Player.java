package rit.stu.act2;

/**
 * The interface for a player object.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public interface Player {

    /**
     * A method called if one player object is victorious over the other player
     * object it is battling.
     *
     * @param player The player object that was defeated.
     */
    void victory (Player player);

    /**
     * A method called if one player object is defeated by the other player
     * object it was battling.
     *
     * @param player The player object that was victorious.
     */
    void defeat (Player player);
}
