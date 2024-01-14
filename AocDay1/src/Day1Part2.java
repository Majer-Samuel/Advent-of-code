import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day1Part2 {

    public static void day1Part2() {
        Map<String, String> numbers = new HashMap<>();
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");

        for (int i = 1; i < 10; i++) {
            numbers.put(String.valueOf(i), String.valueOf(i));
        }
        try (BufferedReader br = LoadText.laodText()) {
            int value = 0;
            for (String line : br.lines().toList()) {

                int first = 0;
                int last = 0;
                int firstIn = Integer.MAX_VALUE;
                int lastIn = -1;

                // Iterate through each number in the map
                for (String key : numbers.keySet()) {
                    // Find the index of the first occurrence of the number in the line
                    int newIndex = line.indexOf(key);
                    if (newIndex < firstIn && newIndex > -1) {
                        firstIn = newIndex;
                        first = Integer.parseInt(numbers.get(key));
                    }

                    // Find the index of the last occurrence of the number in the line
                    int newLastIndex = line.lastIndexOf(key);
                    if (lastIn < newLastIndex) {
                        lastIn = newLastIndex;
                        last = Integer.parseInt(numbers.get(key));
                    }
                }

                value += first * 10 + last;
            }

            System.out.println("The amswer is :" + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

