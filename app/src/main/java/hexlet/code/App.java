package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

public class App {
    private static final String CASE_GREET = "1";
    private static final String CASE_EVEN = "2";
    private static final String CASE_CALC = "3";
    private static final String CASE_GCD = "4";
    private static final String CASE_PROGRESSION = "5";
    private static final String CASE_PRIME = "6";

    public static void main(String[] args) {
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
        /* Used nextLine() method cause nextInt() method use next()
         * method inside. That's why it read \n symbol and return
         * empty string */
        String choice = Utils.readNextLine();
        System.out.println();
        switch (choice) {
            case CASE_GREET:
                Engine.greeting();
                break;
            case CASE_EVEN:
                EvenGame.run();
                break;
            case CASE_CALC:
                CalcGame.run();
                break;
            case CASE_GCD:
                GcdGame.run();
                break;
            case CASE_PROGRESSION:
                ProgressionGame.run();
                break;
            case CASE_PRIME:
                PrimeGame.run();
                break;
            default:
                System.out.println("You choose something wrong!\nPlease restart and try again.");
                break;
        }
        Utils.closeInputScanner();
    }
}
