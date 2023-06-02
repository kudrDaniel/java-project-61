package hexlet.code;

public class Engine {
    public static final int WIN_CONDITION = 3;
    public static final int LENGTH_GAME_DATA = 2;
    public static final int INDEX_QUESTION = 0;
    public static final int INDEX_ANSWER = 1;

    public static void startGame(String gameRules, String[][] gameData) {
        int winCounter = 0;
        // Start by greeting
        String userName = Cli.greeting();
        // Show rules
        System.out.println(gameRules);
        // Start cycle
        do {
            // Show question
            System.out.format(
                    """
                            Question: %s
                            Your answer:\s""",
                    gameData[winCounter][INDEX_QUESTION]
            );
            // Get answer
            String userAnswer = Utils.readNextLine();
            // Check answer
            if (gameData[winCounter][INDEX_ANSWER].equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
                winCounter++;
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        userAnswer,
                        gameData[winCounter][INDEX_ANSWER],
                        userName
                );
                return;
            }
        } while (winCounter < WIN_CONDITION);
        // Show congratulations
        System.out.format("Congratulations, %s!\n", userName);
    }
}
