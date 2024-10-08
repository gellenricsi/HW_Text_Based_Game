package people;

import lombok.Getter;

/**
 * Represents a person with a name who can speak.
 */
@Getter
public abstract class Person {
    //The name of the person
    protected String name;

    /**
     * Creates a new person with the given name.
     * @param name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * @return a message spoken by the person
     */
    public abstract String speak();
}

