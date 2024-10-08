package rooms;

import org.lecture.Colors;
import org.lecture.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Factory class for creating and connecting rooms in the game.
 */
public class RoomFactory {
    /**
     * Connects the rooms together and starts the game with the start room.
     *
     * @param rooms the list of rooms to be connected
     * @throws Exception if there is any error during room connection
     */
    public static void connectRooms(ArrayList<Room> rooms) throws Exception {
        Room StartRoom = new StartRoom("StartRoom");
        Room EndRoom = new EndRoom("Endroom");
        StartRoom.surviveRoom(Game.hero);
        int i=0;
        for (Room room : rooms) {
            room.surviveRoom(Game.hero);
            if(i<rooms.size()-1){
                room.setNextRoom(rooms.get(i+1));
            }else{
                room.setNextRoom(EndRoom);
            }
            i++;
        }
        EndRoom.surviveRoom(Game.hero);
    }

    /**
     * Generates a list of rooms with the given size.
     * @param roomNm the number of rooms to generate
     * @return the list of generated rooms
     * @throws InterruptedException if any thread is interrupted during room generation
     */
    public static ArrayList<Room> generateRooms(int roomNm) throws InterruptedException {
        ArrayList<Room> rooms = new ArrayList<>(roomNm);
        int j = 1;
        for (int i = 0; i < roomNm; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 22);
            if (random % 5 == 0) {
                rooms.add(new MagicRoom("MagicRoom"));
            } else if (random % 3 == 0) {
                System.out.println(Colors.light_blue+Colors.bold+"Ordinary Room - "+j+":"+ Colors.reset);
                System.out.println("How many people do you want to have in the room?");
                int people = TrapRoom.getExpResult();
                System.out.println("How many Villagers do you want to have in the room?");
                int villagers = TrapRoom.getExpResult();
                rooms.add(new OrdinaryRoom("OrdinaryRoom", people, villagers));
                j++;
            } else if (random % 4 == 0) {
                rooms.add(new Tavern("Tavern"));
            } else {
                rooms.add(new TrapRoom("TrapRoom"));
            }
        }
        return rooms;
    }
}
