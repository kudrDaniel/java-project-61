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
        int randOperation = getRandomOperation();
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

    private static int getRandomOperation() {
        return Utils.getRandomInt(0, OPERATION_COUNT);
    }
}
