package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame  implements Game {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public GcdGame() {
        newQuestion();
    }
    public void newQuestion() {
        int randNumber1 = Engine.getRandomInt(1, 50);
        int randNumber2 = Engine.getRandomInt(1, 50);
        this.question = String.format(
                """
                        Question: %s %s
                        Your answer:\s""",
                randNumber1,
                randNumber2
        );
        this.correctAnswer = Integer.toString(gcd(randNumber1, randNumber2));
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

    private int gcd(int numb1, int numb2) {
        return (numb1 % numb2 == 0) ? Math.abs(numb2) : gcd(numb2, numb1 % numb2);
    }
}
