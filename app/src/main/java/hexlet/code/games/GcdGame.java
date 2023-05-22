package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String[] gameData = Engine.createGameDataStorage();
        gameData[Engine.INDEX_RULES] = "Find the greatest common divisor of given numbers.";
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            int currentQuestionIndex = Engine.INDEX_QUESTION + i;
            int currentCorrectAnswerIndex = Engine.INDEX_CORRECT_ANSWER + i;
            newQuestion();
            gameData[currentQuestionIndex] = question;
            gameData[currentCorrectAnswerIndex] = correctAnswer;
        }
        Engine.startGame(gameData);
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
