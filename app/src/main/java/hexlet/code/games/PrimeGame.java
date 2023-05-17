package hexlet.code.games;

import hexlet.code.Utils;

public class PrimeGame {  //TODO
                          // Rework the game logic so that
                          // the engine does not know about
                          // the existence of game classes,
                          // but they did
    private static String question;
    private static String correctAnswer;
    private static final int RAND_NUMBER_ORIGIN = 1;
    private static final int RAND_NUMBER_BOUND = 100;
    public static String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public static void newQuestion() {
        int randNumber = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        correctAnswer = isPrimeNumber(randNumber) ? "yes" : "no";
    }
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
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
