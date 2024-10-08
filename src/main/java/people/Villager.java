package people;

import org.lecture.Colors;

/**
 * A simple representation of a Villager, a type of person.
 */
public class Villager extends Person {
    /**
     * Creates a new villager with the given name.
     * @param name of the villager
     */
    public Villager(String name) {
        super(name);
    }


    /**
     * @return a message spoken by the Villager
     */
    @Override
    public String speak() {
        return Colors.yellow + Colors.bold + "It's too quiet here in the country!" + Colors.reset;
    }
}
