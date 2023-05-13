package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame implements Game {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    public String getRules() {
        return "What is the result of the expression?";
    }
    public CalcGame() {
        newQuestion();
    }
    public void newQuestion() {
        int randOperation = Engine.getRandomInt(0, 3);
        int randNumber1 = Engine.getRandomInt(1, 50);
        int randNumber2 = Engine.getRandomInt(1, 50);
        switch (randOperation) {
            case 0 -> {
                this.question = randNumber1 + " + " + randNumber2;
                this.correctAnswer = Integer.toString(randNumber1 + randNumber2);
            }
            case 1 -> {
                this.question = randNumber1 + " - " + randNumber2;
                this.correctAnswer = Integer.toString(randNumber1 - randNumber2);
            }
            default -> {
                this.question = randNumber1 + " * " + randNumber2;
                this.correctAnswer = Integer.toString(randNumber1 * randNumber2);
            }
        }
        this.question = String.format(
                """
                        Question: %s
                        Your answer:\s""",
                question
        );
        this.correctAnswer = "" + correctAnswer;
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
}
