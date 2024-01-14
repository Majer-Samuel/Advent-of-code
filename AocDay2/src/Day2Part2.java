import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part2 {
    public static void Day2Part2() {
        try {
            Pattern pt = LoadText.Pattern();
            BufferedReader br = LoadText.laodText();
            int value = 0;

            for (String line : br.lines().toList()) {
                String[] arr = line.split(":");
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

                value += blue * green * red;

                System.out.println(value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

