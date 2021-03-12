package calculator.unit.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest extends CalculatorBase {

    @Test
    void sum_TwoDoublePositiveNumbers() {
        assertEquals(calculator.sum(2.4, 2.4), 4.8);
    }

    @DisplayName("Сумма двух целых чисел")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 2, 3",
            "5, 6, 11",
            "-5, 3, -2",
            "-5, -3, -8",
            "-5, 8, 3",
            "10, 22, 32"})
    void sum_TwoNumbers(int x, int y, int z) {
        assertEquals(calculator.sum(x, y), z);
    }

    @Test
    void sum_TwoLongNumbers() {
        assertEquals(calculator.sum(2_000_000, 100_000), 2_100_000);
    }

    @Nested
    class SumZero {
        @Test
        void sum_TwoZeros() {
            assertEquals(calculator.sum(0, 0), 0);
        }

        @Test
        void sum_OneArgumentZero_ResultDoesntChange() {
            assertEquals(calculator.sum(2, 0), 2);
        }
    }
}
