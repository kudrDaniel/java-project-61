package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[Engine.WIN_CONDITION][Engine.LENGTH_GAME_DATA];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameData[i][Engine.INDEX_QUESTION] = question;
            gameData[i][Engine.INDEX_ANSWER] = correctAnswer;
        }
        Engine.startGame(gameRules, gameData);
    }

    public static void newQuestion() {
        int randNumber = Utils.getRandomInt();
        correctAnswer = isPrimeNumber(randNumber) ? "yes" : "no";
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
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
