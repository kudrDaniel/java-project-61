package hexlet.code;

import java.util.Scanner;

public class App {  // TODO
                    // Track that Scanner instance have scanner.close()
    private static final int CASE_EXIT = 0;
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner INPUT_SCANNER = new Scanner(System.in);
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
        int choice = INPUT_SCANNER.nextInt();
        if (choice == CASE_EXIT) {
            return;
        }
        System.out.println();
        Engine.startGame(choice);
        INPUT_SCANNER.close();
    }
    public static Scanner getInputScanner() {
        return INPUT_SCANNER;
    }
}
