package org.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The {@code FileReader} class reads the hero's data from the CSV file.
 * The hero's data includes the player's name and maximum health points.
 */
public class FileReader {

    /**
     * The {@code FileReader} class reads the hero's data from the CSV file.
     * The hero's data includes the player's name and maximum health points.
     * @param path the path to the player data file
     * @return a string array containing the player's name and maximum health points
     */
    public static String[] fileReader(Path path) {
        String[] player = new String[2];

        if (Files.exists(path)) {
            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains("maxHealthPoint")) {
                        continue;
                    }
                    player = line.split(";");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return player;
    }
}
