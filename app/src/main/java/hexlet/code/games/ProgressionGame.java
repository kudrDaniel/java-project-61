package hexlet.code.games;

import hexlet.code.Engine;

import java.util.StringJoiner;

public class ProgressionGame {
    private static String question;
    private static String correctAnswer;
    private static final int PROGRESSION_ORIGIN_ORIGIN = 11;
    private static final int PROGRESSION_ORIGIN_BOUND = 35;
    private static final int PROGRESSION_DIFFERENCE_ORIGIN = 2;
    private static final int PROGRESSION_DIFFERENCE_BOUND = 6;
    private static final int PROGRESSION_LENGTH = 10;
    public static String getRules() {
        return "What number is missing in the progression?";
    }
    public static void newQuestion() {
        int randOrigin = Engine.getRandomInt(PROGRESSION_ORIGIN_ORIGIN, PROGRESSION_ORIGIN_BOUND);
        int randDifference = Engine.getRandomInt(PROGRESSION_DIFFERENCE_ORIGIN, PROGRESSION_DIFFERENCE_BOUND);
        int randHiddenIndex = Engine.getRandomInt(PROGRESSION_LENGTH - PROGRESSION_LENGTH, PROGRESSION_LENGTH);
        question = generateProgression(randOrigin, randDifference, randHiddenIndex);
        question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
        correctAnswer = Integer.toString(randOrigin + randHiddenIndex * randDifference);
    }
    public static String getQuestion() {
        return question;
    }
    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static String generateProgression(int origin, int difference, int hiddenIndex) {
        StringJoiner output = new StringJoiner(" ");
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == hiddenIndex) {
                output.add("..");
            } else {
                output.add(Integer.toString(origin + i * difference));
            }
        }
        return output.toString();
    }
}
