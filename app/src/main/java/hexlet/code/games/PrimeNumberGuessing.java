package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeNumberGuessing implements Game {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public PrimeNumberGuessing() {
        newQuestion();
    }
    public void newQuestion() {
        int randNumber = Engine.getRandomInt(1, 100);
        this.question = String.format(
                """
                        Question: %d
                        Your answer:\s""",
                randNumber
        );
        this.correctAnswer = isPrimeNumber(randNumber) ? "yes" : "no";
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

    private boolean isPrimeNumber(int number) {
        int root = (int) Math.ceil(Math.sqrt((double) number));
        for (int i = 2; i < root; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
