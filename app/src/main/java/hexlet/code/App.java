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
                        3 - Calc
                        0 - Exit
                        Your choice:\s"""
        );
        int choice = scanner.nextInt();
        Engine.startGame(choice);
    }
}
