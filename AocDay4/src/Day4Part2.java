import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4Part2 {
    public static void day4Part2() {
        try (BufferedReader br = LoadText.laodText()) {
            int value = 0;

            List<String> scratchcards = new ArrayList<>(br.lines().toList());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < scratchcards.size(); j++) {
                list.add(1);
            }

            // Iterate through each scratch card
            for (int i = 0; i < scratchcards.size(); i++) {
                // Extract the relevant part of the scratch card containing numbers
                String scratchcard = scratchcards.get(i);
                int cardMatches = 0;

                // Extract winning and regular numbers as lists
                scratchcard = scratchcard.split(":")[1].strip();
                List<String> winningNumbers = Arrays.stream(scratchcard.split("\\|\s*")[0]
                        .strip().split("\\D+")).toList();
                List<String> normalNumbers = Arrays.stream(scratchcard.split("\\|\s*")[1]
                        .strip().split("\\D+")).toList();

                // Iterate through each number on the scratch card
                for (String number : normalNumbers) {
                    // Check if the number is in the list of winning numbers
                    if (winningNumbers.contains(number)) {
                        // Increment the count of card matches and update the list accordingly
                        cardMatches++;
                        list.set(i + cardMatches, list.get(i + cardMatches) + list.get(i));
                    }
                }
            }
            for (int n : list) {
                value += n;
            }
            System.out.println("The answer is: " + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



