package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    private static final Random RAND_SEQUENCE = new Random(System.currentTimeMillis());
    private static final int OPERATION_COUNT = 3;
    private static final int RAND_NUMBER_DEFAULT_ORIGIN = 1;
    private static final int RAND_NUMBER_DEFAULT_BOUND = 100;
    public static String readNextLine() {
        return INPUT_SCANNER.nextLine();
    }
    public static void closeInputScanner() {
        INPUT_SCANNER.close();
    }
    public static int getRandomInt(int origin, int bound) { //TODO Move this method to Util class
        return RAND_SEQUENCE.nextInt(origin, bound);
    }
    public static int getRandomInt() {
        return getRandomInt(RAND_NUMBER_DEFAULT_ORIGIN, RAND_NUMBER_DEFAULT_BOUND);
    }
    public static int getRandomOperation() {
        return getRandomInt(0, OPERATION_COUNT);
    }
}
