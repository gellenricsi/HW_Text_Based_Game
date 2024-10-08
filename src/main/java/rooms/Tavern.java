package rooms;

import org.lecture.Colors;
import org.lecture.Effects;
import org.lecture.Game;
import org.lecture.Player;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a tavern in the game.
 */
public class Tavern extends Room {

    /**
     * Creates a new Tavern room with the given name.
     * @param name the name of the Tavern room
     */
    public Tavern(String name) {
        super(name);
    }
    //Scanner for User input
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Checks if the player survives the Tavern room.
     * The player have to play a dice with an opponent
     * If the player loses, he has to drink a beer and will lose 3 HPs.
     * When wins, nothing happens. he becomes just a message.
     * @param player the player entering the Tavern
     * @return true if the player survives, false, when he dies.
     * @throws Exception if the player dies during the game
     */
    @Override
    public boolean surviveRoom(Player player) throws Exception {
        try {
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the Tavern \"The prancing pony\"!" + Colors.reset);
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Colors.bold + "[Opponent]:" + Colors.reset + Colors.yellow + Colors.bold + " Hello, my name is Mr. Underberg. You must to play a Dice game with me." + Colors.reset);
            Thread.sleep(1500);
            int result1;
            int result2;
            do {
                System.out.println(Colors.yellow + Colors.bold + "To start the game, you must to type in: play" + Colors.reset);
                String play = scanner.nextLine();
                while (!play.equalsIgnoreCase("play")) {
                    Thread.sleep(700);
                    System.out.println(Colors.red + Colors.bold + "Wrong word. Please type in \"play\"!" + Colors.reset);
                    play = Game.sc.nextLine();
                }
                rollingMethod();
                result1 = ThreadLocalRandom.current().nextInt(1, 20);
                System.out.println(Colors.bold + "Your result: " + result1 + Colors.reset);
                Thread.sleep(1000);
                System.out.println(Colors.light_red + Colors.bold + "[Opponent]:" + Colors.reset + Colors.yellow + Colors.bold + " Not bad... not bad... But how good will mine be?" + Colors.reset);
                rollingMethod();
                result2 = ThreadLocalRandom.current().nextInt(1, 20);
                System.out.println(Colors.bold + "Opponent's result: " + result2 + Colors.reset);
                if (result1 == result2) {
                    Thread.sleep(1000);
                    System.out.println(Colors.yellow + Colors.bold + "Draw!");
                    System.out.println("You must to play another game!" + Colors.reset);
                    Thread.sleep(2000);
                }
            } while (result1 == result2);

            Thread.sleep(1000);
            if (result1 > result2) {
                System.out.println(Colors.green + Colors.bold + "You won the game! You have luck." + Colors.reset);
                Thread.sleep(2000);
                System.out.println(Colors.red + Colors.bold + Game.hero.getName() + Colors.green + Colors.bold + " has survived in the " + Colors.red + Colors.bold + "Tavern" + Colors.green + Colors.bold + "! Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
                Thread.sleep(2000);
                System.out.println(Colors.green + Colors.bold + Game.hero.getName() + Colors.reset + Colors.light_green + " Can head towards the next room." + Colors.reset);
                Thread.sleep(1000);
                System.out.println("Onto the next adventure...!");
            } else {
                System.out.println(Colors.red + Colors.bold + "Ohh no... You lost... You must to drink the dwarve's bier." + Colors.reset);
                Thread.sleep(700);
                Game.hero.setCurrentHealthPoint(Game.hero.getCurrentHealthPoint() - 3);
                System.out.println(Colors.red + Colors.bold + "You lost 3 HP. Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint() + Colors.reset);
            }

            if (Game.hero.getCurrentHealthPoint() <= 0) {
                Thread.sleep(1000);
                System.out.println(Effects.graveyard);
                Thread.sleep(2000);
                throw new Exception("You are dead! Game Over!");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Simulates rolling dice.
     * @throws InterruptedException if any thread is interrupted during dice rolling
     */
    private static void rollingMethod() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print("Rolling");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(700);
    }
}
