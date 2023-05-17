package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static String question;
    private static String correctAnswer;
    private static final int OPERATION_PLUS = 0;
    private static final int OPERATION_SUB = 1;
    private static final int RAND_NUMBER_ORIGIN = 1;
    private static final int RAND_NUMBER_BOUND = 50;
    public static void run() {
        String[] gameData = Engine.createGameDataStorage();
        gameData[Engine.INDEX_RULES] = getRules();
        newQuestion();
        gameData[Engine.INDEX_QUESTION] = getQuestion();
        gameData[Engine.INDEX_CORRECT_ANSWER] = getCorrectAnswer();
        Engine.startGame(gameData);
    }
    public static String getRules() {
        return "What is the result of the expression?";
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
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
    }
}
