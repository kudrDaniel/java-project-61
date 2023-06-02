package hexlet.code;

public class Cli {
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
