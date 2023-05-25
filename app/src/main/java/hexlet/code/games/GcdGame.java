package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "Find the greatest common divisor of given numbers.";
        String[] gameQuestions = new String[Engine.WIN_CONDITION];
        String[] gameAnswers = new String[Engine.WIN_CONDITION];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameQuestions[i] = question;
            gameAnswers[i] = correctAnswer;
        }
        Engine.startGame(gameRules, gameQuestions, gameAnswers);
    }

    public static void newQuestion() {
        int randNumber1 = Utils.getRandomInt();
        int randNumber2 = Utils.getRandomInt();
        question = String.format(
                """
                        Question: %s %s
                        Your answer:\s""",
                randNumber1,
                randNumber2
        );
        correctAnswer = Integer.toString(gcd(randNumber1, randNumber2));
    }

    private static int gcd(int numb1, int numb2) {
        return (numb1 % numb2 == 0) ? Math.abs(numb2) : gcd(numb2, numb1 % numb2);
    }
}
