package rooms;

import org.lecture.Colors;
import org.lecture.Effects;
import org.lecture.Game;
import org.lecture.Player;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a trap room in the game.
 */
public class TrapRoom extends Room {

    /**
     * Creates a new TrapRoom with the given name.
     * @param name of the TrapRoom
     */
    public TrapRoom(String name) {
        super(name);
    }
    //Scanner for User input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the player survives the TrapRoom.
     * The Hero have to solve a math example. If he gives an incorrect answer, he loses 5 HPs.
     * @param player the player entering the TrapRoom
     * @return true if the player survives, false if he dies.
     * @throws Exception if the player dies during the game
     */
    @Override
    public boolean surviveRoom(Player player) throws Exception {
        try {
            int firstNm = ThreadLocalRandom.current().nextInt(1, 20);
            int secondNm = ThreadLocalRandom.current().nextInt(1, 20);
            int result = firstNm - secondNm;
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the TrapRoom!" + Colors.reset);
            Thread.sleep(1000);
            System.out.println(Colors.bold + "What is the result of " + firstNm + " - " + secondNm + "?" + Colors.reset);
            int expResult = getExpResult();
            if (Game.hero.getCurrentHealthPoint() > 0) {
                if (expResult == result) {
                    Thread.sleep(1000);
                    System.out.println(Colors.green + Colors.bold + "Luck you have! Congrats! Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
                } else {
                    Thread.sleep(1000);
                    Game.hero.setCurrentHealthPoint(Game.hero.getCurrentHealthPoint() - 5);
                    System.out.println(Colors.red + Colors.bold + "Wrong answer! You lost 5 HP. Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
                }
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Game.hero.getCurrentHealthPoint() <= 0) {
            Thread.sleep(1000);
            System.out.println(Effects.graveyard);
            Thread.sleep(2000);
            throw new Exception("You are dead! Game Over!");
        } else {
            Thread.sleep(2000);
            System.out.println(Colors.red + Colors.bold + Game.hero.getName() + Colors.green + Colors.bold + " has survived in the " + Colors.red + Colors.bold + "TrapRoom!" + Colors.green + Colors.bold + " Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
            Thread.sleep(2000);
            System.out.println(Colors.green + Colors.bold + Game.hero.getName() + Colors.reset + Colors.light_green + " Can head towards the next room." + Colors.reset);
            Thread.sleep(1000);
            System.out.println("Onto the next adventure...!");
            return true;
        }
    }

    /**
     * Gets the expected result from the user input and checks if the given character is an integer.     *
     * @return the expected result entered by the player
     * @throws InterruptedException if any thread is interrupted during user input
     */
    public static int getExpResult() throws InterruptedException {
        int expResult;
        while (true) {
            if (scanner.hasNextInt()) {
                expResult = scanner.nextInt();
                break;
            } else {
                Thread.sleep(1000);
                System.out.println(Colors.red + Colors.bold + "Your answer is not a number. Please try again!" + Colors.reset);
                scanner.next();
            }
        }
        return expResult;
    }
}
