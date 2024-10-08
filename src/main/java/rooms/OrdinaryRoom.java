package rooms;

import org.lecture.Colors;
import org.lecture.Game;
import org.lecture.Player;
import people.Farmer;
import people.Person;
import people.Villager;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ordinary room where the player meets villagers and farmers.
 */
public class OrdinaryRoom extends Room {
    //The number of people
    private int peopleNm;
    //The number of villagers
    private final int villagerNm;
    //ArrayList for the people in the room (Farmers and Villagers)
    public List<Person> personList = new ArrayList<>(peopleNm);

    /**
     * Creates a new OrdinaryRoom with the given name and number of people and villagers.
     * @param name of the OrdinaryRoom
     * @param peopleNm the number of people in the room
     * @param villagerNm the number of villagers in the room
     */
    public OrdinaryRoom(String name, int peopleNm, int villagerNm) {
        super(name);
        this.peopleNm = peopleNm;
        this.villagerNm = villagerNm;
    }

    /**
     * Checks if the player survives the OrdinaryRoom.
     * The people always says something.
     * @param player the player entering the OrdinaryRoom
     * @return true, as the player always survives the OrdinaryRoom
     */
    @Override
    public boolean surviveRoom(Player player) {
        int farmerNm = peopleNm - villagerNm;

        for (int i = 0; i < villagerNm; i++) {
            personList.add(new Villager("Villager"));
        }

        for (int i = 0; i < farmerNm; i++) {
            personList.add(new Farmer("Farmer"));
        }

        try {
            Thread.sleep(1500);
            System.out.println(Colors.light_red + Game.hero.getName() + Colors.light_blue + " has entered the Ordinary Room!" + Colors.reset);
            Thread.sleep(1500);
            System.out.println(Colors.yellow + Colors.bold + "There are some people who want to say something to you..." + Colors.reset);

            for (Person person : personList) {
                Thread.sleep(1000);
                if (person.getName().equalsIgnoreCase("villager")) {
                    System.out.print(Colors.red + Colors.bold + "[Villager]: " + Colors.reset);
                    System.out.println(person.speak());
                } else if (person.getName().equalsIgnoreCase("farmer")) {
                    System.out.print(Colors.red + Colors.bold + "[Farmer]: " + Colors.reset);
                    System.out.println(person.speak());
                }
            }
            Thread.sleep(2000);
            System.out.println(Colors.red + Colors.bold + Game.hero.getName() + Colors.green + Colors.bold + " has survived in the " + Colors.red + Colors.bold + "Ordinary Room" + Colors.green + Colors.bold + "! Remaining HP: " + Colors.reset + Colors.bold + Game.hero.getCurrentHealthPoint());
            Thread.sleep(2000);
            System.out.println(Colors.green + Colors.bold + Game.hero.getName() + Colors.reset + Colors.green + " Can head towards the next room."+ Colors.reset);
            Thread.sleep(1000);
            System.out.println("Onto the next adventure...!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
