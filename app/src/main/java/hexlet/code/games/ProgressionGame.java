package hexlet.code.games;

import hexlet.code.Engine;

import java.util.StringJoiner;

public class ProgressionGame {
    private static String question;
    private static String correctAnswer;
    public static String getRules() {
        return "What number is missing in the progression?";
    }
    public static void newQuestion() {
        int randOrigin = Engine.getRandomInt(11, 35);
        int randDifference = Engine.getRandomInt(2, 6);
        int randHiddenIndex = Engine.getRandomInt(0,10);
        int progressionLength = 10;
        question = generateProgression(randOrigin, randDifference, randHiddenIndex, progressionLength);
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

    private static String generateProgression(int origin, int difference, int hiddenIndex, int length) {
        StringJoiner output = new StringJoiner(" ");
        for(int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                output.add("..");
            } else {
                output.add(Integer.toString(origin + i * difference));
            }
        }
        return output.toString();
    }
}
