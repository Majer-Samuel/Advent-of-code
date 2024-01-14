import java.util.Scanner;

public class Choice {
    public static void choice() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter " + "\n" +
                    "1 for Day2Part1 ->  " + "\n"
                    + "2 for Day2Part2 -> ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter only 1 or 2:");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Day4Part1.day4Part1();
                    break;
                case 2:
                    Day4Part2.day4Part2();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again." + "\n");
            }
        } while (choice != 1 && choice != 2);
    }
}
