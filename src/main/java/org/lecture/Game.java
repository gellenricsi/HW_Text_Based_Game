package org.lecture;

import rooms.Room;
import rooms.RoomFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code Game} class welcomes the hero and calls the method which generates the rooms and
 * the method which connects the rooms together.
 * This method also creates our hero.
 */
public class Game {
    //The name of the file where player data is stored.
    public static final String fileName = "player.csv";
    //Scanner object for reading input from the console.
    public static Scanner sc = new Scanner(System.in);
    //The path to the file to get player data.
    public static final Path path = Paths.get("src", "main", "resources", fileName);
    //The player data read from the file.
    public static final String[] player = FileReader.fileReader(path);
    //Creating our hero/player
    public static Player hero = Player.player(player[0], Integer.parseInt(player[1]));

    /**
     * The {@code playGame} method welcomes the hero and calls the method which generates the rooms and
     * The method which connects the rooms together.
     *
     * @throws Exception if there is an error during game execution
     */
    public static void playGame() throws Exception {

        //output our hero's starting details
        System.out.println(hero);

        //Starting game
        System.out.println(Colors.red + Colors.bold + "Welcome to the " + Colors.yellow + "Magic Game!" + Colors.reset);
        System.out.println(Colors.light_red + "How many rooms do you want to have?" + Colors.reset);
        int roomNm = Game.sc.nextInt();
        while (roomNm < 3) {
            System.out.println(Colors.red + Colors.bold + "You must min. 3 rooms creating to start the game!" + Colors.reset);
            roomNm = Game.sc.nextInt();
        }
        System.out.print(Colors.blue + "Creating rooms" + Colors.reset);
        Thread.sleep(500);
        System.out.print(Colors.blue + "." + Colors.reset);
        Thread.sleep(500);
        System.out.print(Colors.blue + "." + Colors.reset);
        Thread.sleep(500);
        System.out.println(Colors.blue + "." + Colors.reset);
        Thread.sleep(1000);
        System.out.println(Colors.blue + Colors.bold + "The rooms are created!" + Colors.reset);

        //Generate and connect rooms
        ArrayList<Room> rooms = RoomFactory.generateRooms(roomNm);
        RoomFactory.connectRooms(rooms);
    }
}
