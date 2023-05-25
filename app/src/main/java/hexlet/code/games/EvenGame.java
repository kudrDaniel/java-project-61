package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String[] gameQuestions = new String[Engine.WIN_CONDITION];
        String[] gameAnswers = new String[Engine.WIN_CONDITION];
        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameQuestions[i] = question;
            gameAnswers[i] = correctAnswer;
        }
        Engine.startGame(gameRules, gameQuestions, gameAnswers);
    }

    private static void newQuestion() {
        int randNumber = Utils.getRandomInt();
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        correctAnswer = randNumber % 2 == 0 ? "yes" : "no";
    }
}
