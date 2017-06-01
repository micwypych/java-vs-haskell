package unittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static unittesting.UtilityFactorial.factorial;

/**
 * Created by mwypych on 01.06.17.
 */
public class UtilityFactorialJUnitTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void factorialOfNegativeThrowsAnException__1() {
        factorial(-20);
    }

    @Test
    public void factorialOfNegativeThrowsAnException__2() {
        thrown.expect(IllegalArgumentException.class);
        factorial(-20);
    }

    @Test
    public void factorialOfZeroIsOne() {
        assertEquals("factorial(0)", 1, factorial(0));
    }

    @Test
    public void factorialOfOneIsOne() {
        assertEquals("factorial(1)", 1, factorial(1));
    }

    @Test
    public void factorialOfNineIs362880() {
        assertEquals("factorial(9)", 362880, factorial(9));
    }
}
