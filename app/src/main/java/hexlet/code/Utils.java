package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RAND_SEQUENCE = new Random(System.currentTimeMillis());
    public static int getRandomInt(int origin, int bound) { //TODO Move this method to Util class
        return RAND_SEQUENCE.nextInt(origin, bound);
    }
}
