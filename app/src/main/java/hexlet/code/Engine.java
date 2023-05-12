package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void startGame(int choice) {
        int winCounter = 0;
        final int rulesIndex = 0;
        final int questionIndex = 1;
        final int answerIndex = 2;
        final int userAnswerIndex = 3;
        boolean rulesShowed = false;
        String[] gameData;
        Scanner inputScanner = new Scanner(System.in);
        //Start by greeting
        Games.greeting();
        //Start cycle
        do {
            switch (choice) {
                case 2 -> gameData = Games.evenGuessing();
                case 3 -> gameData = Games.calcGame();
                default -> {
                    return;
                }
            }
            //Show rules
            if (!rulesShowed) {
                System.out.println(gameData[rulesIndex]);
                rulesShowed = true;
            }
            //Show question
            System.out.print(gameData[questionIndex]);
            //Get answer
            gameData[userAnswerIndex] = inputScanner.nextLine();
            //Check answer
            if (gameData[userAnswerIndex].equalsIgnoreCase(gameData[answerIndex])) {
                winCounter++;
                System.out.println("Correct!");
            } else {
                System.out.format(
                        """
                            '%s' is wrong answer ;(. Correct answer was '%s'
                            Let's try again, %s!
                            """,
                        gameData[userAnswerIndex],
                        gameData[answerIndex],
                        Games.getUserName()
                );
                return;
            }
        } while (winCounter < 3);
        System.out.format("Congratulations, %s!\n", Games.getUserName());
    }
}
