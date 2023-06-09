package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.WIN_CONDITION][Engine.LENGTH_GAME_DATA];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameData[i][Engine.INDEX_QUESTION] = question;
            gameData[i][Engine.INDEX_ANSWER] = correctAnswer;
        }
        Engine.startGame(gameRules, gameData);
    }

    public static void newQuestion() {
        int randNumber1 = Utils.getRandomInt();
        int randNumber2 = Utils.getRandomInt();
        correctAnswer = Integer.toString(gcd(randNumber1, randNumber2));
        question = randNumber1 + " " + randNumber2;
    }

    private static int gcd(int numb1, int numb2) {
        return (numb1 % numb2 == 0) ? Math.abs(numb2) : gcd(numb2, numb1 % numb2);
    }
}
