package hexlet.code;

import hexlet.code.games.EvenGuessing;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeNumberGuessing;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final int DATA_COUNT = 5;
    private static final int INDEX_USER_NAME = 0;
    private static final int INDEX_RULES = 1;
    private static final int INDEX_QUESTION = 2;
    private static final int INDEX_CORRECT_ANSWER = 3;
    private static final int INDEX_USER_ANSWER = 4;
    private static final int CASE_EVEN = 2;
    private static final int CASE_CALC = 3;
    private static final int CASE_GCD = 4;
    private static final int CASE_PROGRESSION = 5;
    private static final int CASE_PRIME = 6;
    private static final int WIN_CONDITION = 3;
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    private static final Random RAND_SEQUENCE = new Random(System.currentTimeMillis());
    public static void startGame(int choice) {
        int winCounter = 0;
        boolean rulesShowed = false;
        String[] gameData = new String[DATA_COUNT];
        //Start by greeting
        System.out.print(
                """
                        Welcome to the Brain Games!
                        May I have your name?\s"""
        );
        gameData[INDEX_USER_NAME] = INPUT_SCANNER.nextLine();
        System.out.println("Hello, " + gameData[INDEX_USER_NAME] + "!");
        //Start cycle
        do {
            switch (choice) {
                case CASE_EVEN:
                    gameData[INDEX_RULES] = EvenGuessing.getRules();
                    EvenGuessing.newQuestion();
                    gameData[INDEX_QUESTION] = EvenGuessing.getQuestion();
                    gameData[INDEX_CORRECT_ANSWER] = EvenGuessing.getCorrectAnswer();
                    break;
                case CASE_CALC:
                    gameData[INDEX_RULES] = CalcGame.getRules();
                    CalcGame.newQuestion();
                    gameData[INDEX_QUESTION] = CalcGame.getQuestion();
                    gameData[INDEX_CORRECT_ANSWER] = CalcGame.getCorrectAnswer();
                    break;
                case CASE_GCD:
                    gameData[INDEX_RULES] = GcdGame.getRules();
                    GcdGame.newQuestion();
                    gameData[INDEX_QUESTION] = GcdGame.getQuestion();
                    gameData[INDEX_CORRECT_ANSWER] = GcdGame.getCorrectAnswer();
                    break;
                case CASE_PROGRESSION:
                    gameData[INDEX_RULES] = ProgressionGame.getRules();
                    ProgressionGame.newQuestion();
                    gameData[INDEX_QUESTION] = ProgressionGame.getQuestion();
                    gameData[INDEX_CORRECT_ANSWER] = ProgressionGame.getCorrectAnswer();
                    break;
                case CASE_PRIME:
                    gameData[INDEX_RULES] = PrimeNumberGuessing.getRules();
                    PrimeNumberGuessing.newQuestion();
                    gameData[INDEX_QUESTION] = PrimeNumberGuessing.getQuestion();
                    gameData[INDEX_CORRECT_ANSWER] = PrimeNumberGuessing.getCorrectAnswer();
                    break;
                default:
                    return;
            }
            //Show rules
            if (!rulesShowed) {
                System.out.println(gameData[INDEX_RULES]);
                rulesShowed = true;
            }
            //Show question
            System.out.print(gameData[INDEX_QUESTION]);
            //Get answer
            gameData[INDEX_USER_ANSWER] = INPUT_SCANNER.nextLine();
            //Check answer
            if (gameData[INDEX_USER_ANSWER].equalsIgnoreCase(gameData[INDEX_CORRECT_ANSWER])) {
                System.out.println("Correct!");
                winCounter++;
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        gameData[INDEX_USER_ANSWER],
                        gameData[INDEX_CORRECT_ANSWER],
                        gameData[INDEX_USER_NAME]
                );
                return;
            }
        } while (winCounter < WIN_CONDITION);
        System.out.format("Congratulations, %s!\n", gameData[INDEX_USER_NAME]);
    }
    public static int getRandomInt(int origin, int bound) {
        return RAND_SEQUENCE.nextInt(origin, bound);
    }
}
