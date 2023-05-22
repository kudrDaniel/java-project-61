package hexlet.code;

import java.util.Arrays;

public class Engine {
    public static final int WIN_CONDITION = 3;
    public static final int INDEX_USER_NAME = 0;
    public static final int INDEX_RULES = 1;
    public static final int INDEX_QUESTION = 2;
    public static final int INDEX_CORRECT_ANSWER = INDEX_QUESTION + WIN_CONDITION;
    public static final int INDEX_USER_ANSWER = INDEX_CORRECT_ANSWER + WIN_CONDITION;
    private static final int DATA_COUNT = WIN_CONDITION * 2 + 3;
    private static int winCounter = 0;
    private static String[] gameDataStorage = createGameDataStorage();

    public static void startGame(String[] gameData) {
        boolean rulesShowed = false;
        //Load data from obtain to current
        gameDataStorage = Arrays.copyOf(gameData, DATA_COUNT);
        //Start by greeting
        greeting();
        //Start cycle
        do {
            //Show rules
            if (!rulesShowed) {
                System.out.println(gameDataStorage[INDEX_RULES]);
                rulesShowed = true;
            }
            //Show question
            showQuestion(winCounter);
            //Get answer
            gameDataStorage[INDEX_USER_ANSWER] = Utils.readNextLine();
            //Check answer
            if (!showCheckPass(checkAnswer(winCounter))) {
                return;
            }
        } while (winCounter < WIN_CONDITION);
        //Show congratulations
        System.out.format("Congratulations, %s!\n", gameDataStorage[INDEX_USER_NAME]);
    }

    public static String[] createGameDataStorage() {
        return new String[DATA_COUNT];
    }

    public static void greeting() {
        System.out.print(
                """
                        Welcome to the Brain Games!
                        May I have your name?\s"""
        );
        gameDataStorage[INDEX_USER_NAME] = Utils.readNextLine();
        System.out.println("Hello, " + gameDataStorage[INDEX_USER_NAME] + "!");
    }

    private static void showQuestion(int questionNumber) {
        int currentQuestionIndex = INDEX_QUESTION + questionNumber;
        System.out.print(gameDataStorage[currentQuestionIndex]);
    }

    private static boolean checkAnswer(int questionNumber) {
        int currentCorrectAnswerIndex = INDEX_CORRECT_ANSWER + questionNumber;
        return gameDataStorage[INDEX_USER_ANSWER].equalsIgnoreCase(gameDataStorage[currentCorrectAnswerIndex]);
    }

    private static boolean showCheckPass(boolean check) {
        if (check) {
            System.out.println("Correct!");
            winCounter++;
        } else {
            System.out.format(
                    """
                        '%s' is wrong answer ;(. Correct answer was '%s'
                        Let's try again, %s!
                        """,
                    gameDataStorage[INDEX_USER_ANSWER],
                    gameDataStorage[INDEX_CORRECT_ANSWER],
                    gameDataStorage[INDEX_USER_NAME]
            );
        }
        return check;
    }
}
