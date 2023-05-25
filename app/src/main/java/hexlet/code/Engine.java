package hexlet.code;

public class Engine {
    public static final int WIN_CONDITION = 3;

    public static void startGame(String gameRules, String[] gameQuestions, String[] gameAnswers) {
        boolean rulesShowed = false;
        int winCounter = 0;
        //Start by greeting
        String userName = greeting();
        //Show rules
        if (!rulesShowed) {
            System.out.println(gameRules);
            rulesShowed = true;
        }
        //Start cycle
        do {
            //Show question
            System.out.print(gameQuestions[winCounter]);
            //Get answer
            String userAnswer = Utils.readNextLine();
            //Check answer
            if (gameAnswers[winCounter].equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
                winCounter++;
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        userAnswer,
                        gameAnswers[winCounter],
                        userName
                );
                return;
            }
        } while (winCounter < WIN_CONDITION);
        //Show congratulations
        System.out.format("Congratulations, %s!\n", userName);
    }

    public static String greeting() {
        System.out.print(
                """
                        Welcome to the Brain Games!
                        May I have your name?\s"""
        );
        String userName = Utils.readNextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
