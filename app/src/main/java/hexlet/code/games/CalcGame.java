package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame{
    private static String question;
    private static String correctAnswer;
    public static String getRules() {
        return "What is the result of the expression?";
    }
    public static void newQuestion() {
        int randOperation = Engine.getRandomInt(0, 3);
        int randNumber1 = Engine.getRandomInt(1, 50);
        int randNumber2 = Engine.getRandomInt(1, 50);
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
