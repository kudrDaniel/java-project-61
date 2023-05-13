package hexlet.code.games;

import hexlet.code.Engine;
public class EvenGuessing implements Game {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public EvenGuessing() {
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
        this.correctAnswer = randNumber % 2 == 0 ? "yes" : "no";
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
