package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final int OPERATION_PLUS = 0;
    private static final int OPERATION_SUB = 1;
    private static final int OPERATION_MUL = 2;
    private static final String[] OPERATIONS = {" + ", " - ", " * "};
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
        correctAnswer = Integer.toString(calculate(randNumber1, randNumber2, randOperation));
        question = randNumber1 + OPERATIONS[randOperation] + randNumber2;
    }

    private static int calculate(int number1, int number2, int operation) {
        switch (operation) {
            case OPERATION_PLUS:
                return number1 + number2;
            case OPERATION_SUB:
                return number1 - number2;
            case OPERATION_MUL:
                return number1 * number2;
            default:
                System.out.println("Something wrong with operation index");
                return 0;
        }
    }

    private static int getRandomOperation() {
        return Utils.getRandomInt(0, OPERATIONS.length);
    }
}
