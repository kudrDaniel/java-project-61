package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    private static String question;
    private static String correctAnswer;
    public static void run() {
        String[] gameData = Engine.createGameDataStorage();
        gameData[Engine.INDEX_RULES] = getRules();
        newQuestion();
        gameData[Engine.INDEX_QUESTION] = getQuestion();
        gameData[Engine.INDEX_CORRECT_ANSWER] = getCorrectAnswer();
        Engine.startGame(gameData);
    }
    public static String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public static void newQuestion() {
        int randNumber1 = Utils.getRandomInt();
        int randNumber2 = Utils.getRandomInt();
        question = String.format(
                """
                        Question: %s %s
                        Your answer:\s""",
                randNumber1,
                randNumber2
        );
        correctAnswer = Integer.toString(gcd(randNumber1, randNumber2));
    }
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static int gcd(int numb1, int numb2) {
        return (numb1 % numb2 == 0) ? Math.abs(numb2) : gcd(numb2, numb1 % numb2);
    }
}
