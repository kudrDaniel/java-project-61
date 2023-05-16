package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame { //TODO
                        // Rework the game logic so that
                        // the engine does not know about
                        // the existence of game classes,
                        // but they did
    private static String question;
    private static String correctAnswer;
    private static final int OPERATION_COUNT = 3;
    private static final int RAND_NUMBER_ORIGIN = 1;
    private static final int RAND_NUMBER_BOUND = 50;
    public static String getRules() {
        return "What is the result of the expression?";
    }
    public static void newQuestion() {
        int randOperation = Utils.getRandomInt(OPERATION_COUNT - OPERATION_COUNT, OPERATION_COUNT);
        int randNumber1 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        int randNumber2 = Utils.getRandomInt(RAND_NUMBER_ORIGIN, RAND_NUMBER_BOUND);
        switch (randOperation) {
            case 0 -> {
                question = randNumber1 + " + " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 + randNumber2);
            }
            case 1 -> {
                question = randNumber1 + " - " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 - randNumber2);
            }
            default -> {
                question = randNumber1 + " * " + randNumber2;
                correctAnswer = Integer.toString(randNumber1 * randNumber2);
            }
        }
        question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
    }
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
    }
}
