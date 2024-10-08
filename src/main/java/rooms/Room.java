package rooms;

import lombok.Getter;
import lombok.Setter;
import org.lecture.Player;


/**
 * Represents a room in the game.
 */
@Getter
@Setter
public abstract class Room {
    //Name of the room
    protected String name;
    //the next room, to which this room connects.
    protected Room nextRoom;

    /**
     * Creates a new Room with the given name.
     *
     * @param name of the Room
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * Method to check if the player survives the room.
     *
     * @param player the player entering the room.
     * @return true if the player survives the room, false when not.
     * @throws Exception if there is any error during room survival check.
     */
    public abstract boolean surviveRoom(Player player) throws Exception;
}
