package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeNumberGuessing {
    private static String question;
    private static String correctAnswer;
    public static String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public static void newQuestion() {
        int randNumber = Engine.getRandomInt(1, 100);
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
        int root = (int) Math.ceil(Math.sqrt((double) number));
        for (int i = 2; i < root; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
