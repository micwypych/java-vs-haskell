package unittesting;

/**
 * Created by mwypych on 01.06.17.
 */
public class UtilityFactorial {
    public static int factorial(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value cannot be less than 0");
        }
        if (value == 0) {
            return 1;
        }
        return value * factorial(value-1);
    }
}
