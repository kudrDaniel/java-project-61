package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        String userName;
        Scanner inputScanner = new Scanner(System.in);
        System.out.print(
                "Welcome to the Brain Games\n"
                + "May I have your name? "
        );
        userName = inputScanner.nextLine();
        System.out.format(
                "Hello? %s!",
                userName
        );
        inputScanner.close();
    }
}
