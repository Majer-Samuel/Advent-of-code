import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part1 {

    // Method to calculate the value based on certain conditions in the provided text file
    public static void day2part1() {
        try {
            Pattern pt = LoadText.Pattern();
            BufferedReader br = LoadText.laodText();

            int value = 0;

            for (String line : br.lines().toList()) {
                String[] arr = line.split(":");
                int numOfTheGame = Integer.parseInt(arr[0].replace("Game", "").trim());
                int blue = 0;
                int green = 0;
                int red = 0;

                // Iterate through each round in the cube information
                for (String rounds : arr[1].split(";")) {
                    // Iterate through each cube in the round
                    for (String cubes : rounds.split(",")) {
                        // Use regex to match and extract cube color and value
                        Matcher m = pt.matcher(cubes);
                        if (m.find()) {
                            // Update the maximum value for each cube color
                            switch (m.group(2)) {
                                case "blue":
                                    int newblue = Integer.parseInt(m.group(1));
                                    if (newblue > blue) {
                                        blue = newblue;
                                    }
                                    break;
                                case "red":
                                    int newred = Integer.parseInt(m.group(1));
                                    if (newred > red) {
                                        red = newred;
                                    }
                                    break;
                                case "green":
                                    int newgreen = Integer.parseInt(m.group(1));
                                    if (newgreen > green) {
                                        green = newgreen;
                                    }
                                    break;
                            }
                        }
                    }
                }

                // Check if the conditions for red, green, and blue are satisfied
                if (red <= 12 && green <= 13 && blue <= 14) {
                    // Update the overall value
                    value += numOfTheGame;
                }
            }
            System.out.println("The answer is :" + value);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
