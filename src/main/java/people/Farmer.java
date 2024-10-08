package people;

import org.lecture.Colors;

/**
 * A simple representation of a farmer, a type of person.
 */
public class Farmer extends Person {
    /**
     * Creates a new farmer with the given name.
     * @param name of the farmer
     */
    public Farmer(String name) {
        super(name);
    }

    /**
     * @return a message spoken by the farmer.
     */
    @Override
    public String speak() {
        return Colors.yellow + Colors.bold + "The harvest will be good this year!" + Colors.reset;
    }
}
