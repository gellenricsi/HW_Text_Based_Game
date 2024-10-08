package rooms;

import org.lecture.Colors;
import org.lecture.Effects;
import org.lecture.Game;
import org.lecture.Player;

/**
 * Represents the final room in the game where the player wins.
 */
public class EndRoom extends Room {

    /**
     * @param name the name of the EndRoom
     */
    public EndRoom(String name) {
        super(name);
    }

    /**
     * Checks if the player survives the EndRoom with more the 10 HP or not.
     *
     * @param player the player entering the EndRoom
     * @return true, as the player always survives the EndRoom
     */
    @Override
    public boolean surviveRoom(Player player) {
        try {
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the EndRoom!" + Colors.reset);
            Thread.sleep(1500);
            System.out.println(Colors.yellow + Colors.bold + "Yuuuuuuhuu" + Colors.reset);
            Thread.sleep(1000);
            System.out.println(Colors.green + Colors.bold + "You won the game! Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
            Thread.sleep(1500);
            if (Game.hero.getCurrentHealthPoint() >= 10) {
                System.out.println(Effects.fireworks);
            }
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
