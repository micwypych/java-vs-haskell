package unittesting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static unittesting.UtilityFactorial.factorial;

/**
 * Created by mwypych on 01.06.17.
 */
public class UtilityFactorialAssertJTest {
    @Test
    public void factorialOfNegativeThrowsAnException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            factorial(-20);
        });
    }

    @Test
    public void factorialOfZeroIsOne() {
        assertThat(factorial(0)).isEqualTo(1);
    }

    @Test
    public void factorialOfOneIsOne() {
        assertThat(factorial(1)).isEqualTo(1);
    }

    @Test
    public void factorialOfNineIs362880() {
        assertThat(factorial(9)).isEqualTo(362880);
    }
}
