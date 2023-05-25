package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] gameQuestions = new String[Engine.WIN_CONDITION];
        String[] gameAnswers = new String[Engine.WIN_CONDITION];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameQuestions[i] = question;
            gameAnswers[i] = correctAnswer;
        }
        Engine.startGame(gameRules, gameQuestions,gameAnswers);
    }

    public static void newQuestion() {
        int randNumber = Utils.getRandomInt();
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        correctAnswer = isPrimeNumber(randNumber) ? "yes" : "no";
    }

    private static boolean isPrimeNumber(int number) {
        int dividerOrigin = 2;
        int rootOffset = 1;
        int root = (int) Math.floor(Math.sqrt(number)) + rootOffset;
        for (int i = dividerOrigin; i < root; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
