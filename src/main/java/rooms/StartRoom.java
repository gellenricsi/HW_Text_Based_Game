package rooms;

import org.lecture.Colors;
import org.lecture.Game;
import org.lecture.Player;

/**
 * Represents the starting room of the game.
 */
public class StartRoom extends Room {

    /**
     * Creates a new StartRoom with the given name.
     * @param name of the StartRoom
     */
    public StartRoom(String name) {
        super(name);
    }

    /**
     * Checks if the player survives the StartRoom.
     * @param player the player entering the StartRoom
     * @return true, as the player always survives the StartRoom
     */
    @Override
    public boolean surviveRoom(Player player) {

        try {
            Thread.sleep(1500);
            System.out.println(Colors.light_blue + "Player " + Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the game. Onwards the journey goes..." + Colors.reset);
            Thread.sleep(2000);
            System.out.println(Colors.red + Colors.bold + Game.hero.getName() + Colors.reset + Colors.green + Colors.bold + " has survived in " + Colors.red + Colors.bold + "StartRoom" + Colors.reset + Colors.green + Colors.bold + ".  Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
            Thread.sleep(1000);
            System.out.println("Onto the next adventure...!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
