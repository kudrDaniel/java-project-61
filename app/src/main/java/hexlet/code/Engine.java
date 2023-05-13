package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGuessing;
import hexlet.code.games.Game;
import hexlet.code.games.GcdGame;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    private static final Random RAND_SEQUENCE = new Random(System.currentTimeMillis());
    public static void startGame(int choice) {
        int winCounter = 0;
        boolean rulesShowed = false;
        Game currentGame;
        //Start by greeting
        System.out.print(
                """
                        Welcome to the Brain Games
                        May I have your name?\s"""
        );
        String userName = INPUT_SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
        //Start cycle
        do {
            switch (choice) {
                case 2:
                    currentGame = new EvenGuessing();
                    break;
                case 3:
                    currentGame = new CalcGame();
                    break;
                case 4:
                    currentGame = new GcdGame();
                    break;
                default:
                    return;
            }
            //Show rules
            if (!rulesShowed) {
                System.out.println(currentGame.getRules());
                rulesShowed = true;
            }
            //Show question
            System.out.print(currentGame.getQuestion());
            //Get answer
            currentGame.setUserAnswer();
            //Check answer
            if (currentGame.getUserAnswer().equalsIgnoreCase(currentGame.getCorrectAnswer())) {
                winCounter++;
                currentGame.newQuestion();
                System.out.println("Correct!");
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        currentGame.getUserAnswer(),
                        currentGame.getCorrectAnswer(),
                        userName
                );
                return;
            }
        } while (winCounter < 3);
        System.out.format("Congratulations, %s!\n", userName);
    }
    public static Scanner getInputScanner() {
        return INPUT_SCANNER;
    }
    public static int getRandomInt(int origin, int bound) {
        return RAND_SEQUENCE.nextInt(origin, bound);
    }
}
