import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Day1Part1 {
    public static void day1Part1() {
        try {
            LoadText.laodText();
            BufferedReader br = LoadText.laodText();
            int value = 0;

            for (String line : br.lines().toList()) {
                int first = -1;
                int last = -1;
                // Iterate through each character in the line
                for (String c : line.split("")) {
                    // Check if the character is a digit
                    if (Character.isDigit(c.charAt(0))) {
                        // If 'first' is not set, set it to the current digit; otherwise, update 'last'
                        if (first == -1) {
                            first = Integer.parseInt(c);
                        }
                        last = Integer.parseInt(c);
                    }
                }

                first *= 10;
                value += first + last;
            }

            System.out.println("The amswer is : " + value);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



