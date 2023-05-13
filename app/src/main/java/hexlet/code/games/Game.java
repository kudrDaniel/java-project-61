package hexlet.code.games;

public interface Game {
    String getRules();
    void newQuestion();
    String getQuestion();
    String getCorrectAnswer();
    void setUserAnswer();
    String getUserAnswer();
}
