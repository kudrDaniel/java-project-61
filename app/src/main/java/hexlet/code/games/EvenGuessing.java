package hexlet.code.games;

import hexlet.code.Engine;
public class EvenGuessing {
    private static String question;
    private static String correctAnswer;
    public static String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public static void newQuestion() {
        int randNumber = Engine.getRandomInt(1, 100);
        question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        correctAnswer = randNumber % 2 == 0 ? "yes" : "no";
    }
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
    }
}
