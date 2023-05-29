package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int OPERATION_COUNT = 3;
    private static final int OPERATION_PLUS = 0;
    private static final int OPERATION_SUB = 1;
    private static final int RAND_NUMBER_ORIGIN = 1;
    private static final int RAND_NUMBER_BOUND = 50;
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "What is the result of the expression?";
        String[][] gameData = new String[Engine.WIN_CONDITION][Engine.LENGTH_GAME_DATA];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameData[i][Engine.INDEX_QUESTION] = question;
            gameData[i][Engine.INDEX_ANSWER] = correctAnswer;
        }
        Engine.startGame(gameRules, gameData);
    }

    public static void newQuestion() {
        int randOperation = getRandomOperation();
        int randNumber1 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        int randNumber2 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        correctAnswer = calculate(randNumber1, randNumber2, randOperation);
        switch (randOperation) {
            case OPERATION_PLUS:
                question = randNumber1 + " + " + randNumber2;
                break;
            case OPERATION_SUB:
                question = randNumber1 + " - " + randNumber2;
                break;
            default:
                question = randNumber1 + " * " + randNumber2;
                break;
        }
        question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
    }

    private static String calculate(int number1, int number2, int operation) {
        switch (operation) {
            case OPERATION_PLUS:
                return Integer.toString(number1 + number2);
            case OPERATION_SUB:
                return Integer.toString(number1 - number2);
            default:
                return Integer.toString(number1 * number2);
        }
    }

    private static int getRandomOperation() {
        return Utils.getRandomInt(0, OPERATION_COUNT);
    }
}
