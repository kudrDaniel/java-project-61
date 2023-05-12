package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(
                """
                        Please enter the game number and press Enter.
                        1 - Greet
                        2 - Even
                        0 - Exit
                        Your choice:\s"""
        );
        int choice = scanner.nextInt();
        System.out.println();
        switch (choice) {
            case 1 -> Games.greeting();
            case 2 -> Games.evenGuessing();
        }

    }
}
