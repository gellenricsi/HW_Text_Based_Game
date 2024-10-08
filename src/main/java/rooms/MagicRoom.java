package rooms;

import org.lecture.Colors;
import org.lecture.Game;
import org.lecture.Player;

import java.util.Scanner;

/**
 * Represents a magic room where the player meets a wizard.
 */
public class MagicRoom extends Room {
    /**
     * Creates a new MagicRoom with the given name.
     * @param name of the MagicRoom
     */
    public MagicRoom(String name) {
        super(name);
    }

    //Scanner for user input.
    public Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the player survives the MagicRoom.
     * The player gets 5 HP when the magic word is longer than 10 Character.
     * The player gets 3 HP when the magic word is shorter than 10 Character.
     * @param player the player entering the MagicRoom
     * @return true, as the player always survives the MagicRoom
     */
    @Override
    public boolean surviveRoom(Player player) {
        try {
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the Magic Room!" + Colors.reset);
            Thread.sleep(1500);
            System.out.println(Colors.yellow + Colors.bold + "A wizard shows up and demand you say a magic spell!");
            Thread.sleep(1500);
            System.out.println("What spell do you want to use?" + Colors.reset);
            String spell = scanner.nextLine();
            Thread.sleep(1000);
            System.out.println(Colors.bold + "Magic!" + Colors.reset);
            Thread.sleep(500);
            int currentHealth;
            if (spell.length() >= 10) {
                currentHealth = Game.hero.getCurrentHealthPoint() + 5;
                Game.hero.setCurrentHealthPoint(currentHealth);
                System.out.println(Colors.light_red + Colors.bold + Game.hero.getName() + Colors.light_green + Colors.bold + " heals by 5 points and the wizard vanishes..." + Colors.reset);
            } else if (spell.isEmpty()) {
                System.out.println(Colors.light_red + "Sorry, but if you don't talk, we can't do magic. Bye bye!" + Colors.reset);
            } else {
                currentHealth = Game.hero.getCurrentHealthPoint() + 3;
                Game.hero.setCurrentHealthPoint(currentHealth);
                System.out.println(Colors.light_red + Colors.bold + Game.hero.getName() + Colors.light_green + Colors.bold + " heals by 3 points and the wizard vanishes..." + Colors.reset);
            }
            Thread.sleep(2000);
            System.out.println(Colors.red + Colors.bold + Game.hero.getName() + Colors.green + Colors.bold + " has survived in the " + Colors.red + Colors.bold + "Magic Room" + Colors.green + Colors.bold + "!  Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint());
            Thread.sleep(2000);
            System.out.println(Colors.green + Colors.bold + Game.hero.getName() + Colors.reset + Colors.green + " Can head towards the next room." + Colors.reset);
            Thread.sleep(1000);
            System.out.println("Onto the next adventure...!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
