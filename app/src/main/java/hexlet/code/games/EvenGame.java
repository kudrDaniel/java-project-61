package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String[] gameData = Engine.createGameDataStorage();
        gameData[Engine.INDEX_RULES] = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
