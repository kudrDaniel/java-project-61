package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Games {
    public static void greeting(StringBuilder userName) {
        Scanner inputScan = new Scanner(System.in);
        System.out.print(
                """
                    Welcome to the Brain Games
                    May I have your name?\s"""
        );
        userName.append(inputScan.nextLine());
        System.out.println("Hello, " + userName + "!");
    }
    public  static void greeting() {
        greeting(new StringBuilder());
    }
    public  static void evenGuessing() {
        StringBuilder userName = new StringBuilder();
        greeting(userName);
        Scanner inputScan = new Scanner(System.in);
        int winCounter = 0;
        Random randSequence = new Random(System.currentTimeMillis());
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        do {
            int randNumber = randSequence.nextInt(1, 100);
            System.out.format(
                    """
                        Question: %d
                        Your answer:\s""",
                    randNumber
            );
            String userAnswer = inputScan.nextLine();
            String correctAnswer = randNumber % 2 == 0 ? "yes" : "no";
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                winCounter++;
                System.out.println("Correct!");
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        userAnswer,
                        correctAnswer,
                        userName
                );
                break;
            }

        } while (winCounter < 3);
        System.out.format("Congratulations, %s!\n", userName);
    }
}
