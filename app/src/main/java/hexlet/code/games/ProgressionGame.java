package hexlet.code.games;

import hexlet.code.Engine;

import java.util.StringJoiner;

public class ProgressionGame implements Game {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    public String getRules() {
        return "What number is missing in the progression?";
    }
    public ProgressionGame() {
        newQuestion();
    }
    public void newQuestion() {
        int randOrigin = Engine.getRandomInt(11, 35);
        int randDifference = Engine.getRandomInt(2, 6);
        int randHiddenIndex = Engine.getRandomInt(0,10);
        int progressionLength = 10;
        this.question = generateProgression(randOrigin, randDifference, randHiddenIndex, progressionLength);
        this.question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
        this.correctAnswer = Integer.toString(randOrigin + randHiddenIndex * randDifference);
    }
    public String getQuestion() {
        return this.question;
    }
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
    public void setUserAnswer() {
        this.userAnswer = Engine.getInputScanner().nextLine();
    }
    public String getUserAnswer() {
        return this.userAnswer;
    }

    private String generateProgression(int origin, int difference, int hiddenIndex, int length) {
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
