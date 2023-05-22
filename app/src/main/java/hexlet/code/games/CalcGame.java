package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int OPERATION_PLUS = 0;
    private static final int OPERATION_SUB = 1;
    private static final int RAND_NUMBER_ORIGIN = 1;
    private static final int RAND_NUMBER_BOUND = 50;
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String[] gameData = Engine.createGameDataStorage();
        gameData[Engine.INDEX_RULES] = "What is the result of the expression?";
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
        int randOperation = Utils.getRandomOperation();
        int randNumber1 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        int randNumber2 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        switch (randOperation) {
            case OPERATION_PLUS:
                question = randNumber1 + " + " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 + randNumber2);
                break;
            case OPERATION_SUB:
                question = randNumber1 + " - " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 - randNumber2);
                break;
            default:
                question = randNumber1 + " * " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 * randNumber2);
                break;
        }
        question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
    }
}
