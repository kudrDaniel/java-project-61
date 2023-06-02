package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {
    private static final int PROGRESSION_ORIGIN_ORIGIN = 11;
    private static final int PROGRESSION_ORIGIN_BOUND = 35;
    private static final int PROGRESSION_DIFFERENCE_ORIGIN = 2;
    private static final int PROGRESSION_DIFFERENCE_BOUND = 6;
    private static final int PROGRESSION_LENGTH = 10;
    private static String question;
    private static String correctAnswer;

    public static void run() {
        String gameRules = "What number is missing in the progression?";
        String[][] gameData = new String[Engine.WIN_CONDITION][Engine.LENGTH_GAME_DATA];
        for (int i = 0; i < Engine.WIN_CONDITION; i++) {
            newQuestion();
            gameData[i][Engine.INDEX_QUESTION] = question;
            gameData[i][Engine.INDEX_ANSWER] = correctAnswer;
        }
        Engine.startGame(gameRules, gameData);
    }

    public static void newQuestion() {
        int randOrigin = Utils.getRandomInt(PROGRESSION_ORIGIN_ORIGIN, PROGRESSION_ORIGIN_BOUND);
        int randDifference = Utils.getRandomInt(PROGRESSION_DIFFERENCE_ORIGIN, PROGRESSION_DIFFERENCE_BOUND);
        int randHiddenIndex = Utils.getRandomInt(0, PROGRESSION_LENGTH);
        String[] progression = generateProgression(randOrigin, randDifference);
        correctAnswer = progression[randHiddenIndex];
        progression[randHiddenIndex] = "..";
        question = String.join(" ", progression);
    }

    private static String[] generateProgression(int origin, int difference) {
        String[] output = new String[PROGRESSION_LENGTH];
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            output[i] = Integer.toString(origin + i * difference);
        }
        return output;
    }
}
