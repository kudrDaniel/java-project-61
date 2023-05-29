package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[Engine.WIN_CONDITION][Engine.LENGTH_GAME_DATA];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameData[i][Engine.INDEX_QUESTION] = question;
            gameData[i][Engine.INDEX_ANSWER] = correctAnswer;
        }
        Engine.startGame(gameRules, gameData);
    }

    private static void newQuestion() {
        int randNumber = Utils.getRandomInt();
        correctAnswer = isEven(randNumber) ? "yes" : "no";
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
