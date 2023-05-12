package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Games {
    private static String userName = "";
    private static final Scanner inputScanner = new Scanner(System.in);
    private static int winCounter = 0;
    private static final Random randSequence = new Random(System.currentTimeMillis());
    public static String getUserName() {
        return userName;
    }
    public static void greeting() {
        System.out.print(
                """
                    
                    Welcome to the Brain Games
                    May I have your name?\s"""
        );
        userName = inputScanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public  static String[] evenGuessing() {
        String[] gameData = new String[4];
        gameData[0] = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int randNumber = randSequence.nextInt(1, 100);
        gameData[1] = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        gameData[2] = randNumber % 2 == 0 ? "yes" : "no";
        gameData[3] = "";
        return gameData;
    }
    public static String[] calcGame() {
        String[] gameData = new String[4];
        gameData[0] = "What is the result of the expression?";
        int randOperation = randSequence.nextInt(0, 3);
        int randNumber1 = randSequence.nextInt(1, 50);
        int randNumber2 = randSequence.nextInt(1, 50);
        String question;
        int correctAnswer;
        switch (randOperation) {
            case 0:
                question = randNumber1 + " + " + randNumber2;
                correctAnswer = randNumber1 + randNumber2;
                break;
            case 1:
                question = randNumber1 + " - " + randNumber2;
                correctAnswer = randNumber1 - randNumber2;
                break;
            default:
                question = randNumber1 + " * " + randNumber2;
                correctAnswer = randNumber1 * randNumber2;
                break;
        }
        gameData[1] = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
        gameData[2] = "" + correctAnswer;
        gameData[3] = "";
        return gameData;
    }
}
