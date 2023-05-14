package hexlet.code;

import java.util.Scanner;

public class App {
    private static final int CASE_EXIT = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                """
                        Please enter the game number and press Enter.
                        1 - Greet
                        2 - Even
                        3 - Calc
                        4 - GCD
                        5 - Progression
                        6 - Prime
                        0 - Exit
                        Your choice:\s"""
        );
        int choice = scanner.nextInt();
        if (choice == CASE_EXIT) {
            return;
        }
        System.out.println();
        Engine.startGame(choice);
    }
}
