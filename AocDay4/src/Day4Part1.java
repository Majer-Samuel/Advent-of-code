import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day4Part1 {
    public static void day4Part1() {
        try (BufferedReader br = LoadText.laodText()) {
            int value = 0;

            for (String line : br.lines().toList()) {
                int valueOfTheCard = 0;

                // Extract the relevant part of the line containing card numbers
                line = line.split(":")[1].strip();

                // Extract winning and regular numbers as lists
                List<String> winningNumbers = Arrays.stream(line.split("\\|\s")[0]
                        .strip().split("\\D+")).toList();
                List<String> numbers = Arrays.stream(line.split("\\|\s")[1]
                        .strip().split("\\D+")).toList();

                // Iterate through each number on the card
                for (String number : numbers) {
                    // Check if the number is in the list of winning numbers
                    if (winningNumbers.contains(number)) {
                        // Update the value of the card based on the winning condition
                        valueOfTheCard = (valueOfTheCard == 0) ? 1 : valueOfTheCard * 2;
                    }
                }
                value += valueOfTheCard;
            }
            System.out.println("The answer is: " + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

