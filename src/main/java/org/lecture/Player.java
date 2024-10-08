package org.lecture;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Player {
    //The name of the file where player data is stored.
    public static final String fileName = "player.csv";
    //Scanner object for reading input from the console.
    public static Scanner sc = new Scanner(System.in);
    //The path to the file to get player data.
    public static final Path path = Paths.get("src", "main", "resources", fileName);
    //The name of the player.
    private String name;
    //The maximum health points of the player.
    private int maxHealthPoint;
    //The current health points of the player.
    private int currentHealthPoint;

    /**
     * Creates a new player from datas from the file.
     * If the name is empty, the user have to enter a name via the console.
     * If the maximum health points are less than or equal to zero, sets it to a default value of 12.
     * @param name the name of the player
     * @param maxHealthPoint the maximum health points of the player
     * @return a new {@code Player}
     */
    public static Player player(String name, int maxHealthPoint) {
        Player hero = new Player();
        if (name.isEmpty()) {
            System.out.println(Colors.yellow + Colors.bold + "Please enter your Hero's name: " + Colors.reset);
            name = sc.nextLine();
        }
        if (maxHealthPoint <= 0) {
            maxHealthPoint = 12;
        }
        hero.setName(name);
        hero.setMaxHealthPoint(maxHealthPoint);
        hero.setCurrentHealthPoint(maxHealthPoint);
        return hero;
    }
}
