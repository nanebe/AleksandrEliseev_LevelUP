package calculator.unit.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideTest extends CalculatorBase {

    @Test
    @DisplayName("Деление на ноль")
    void divide_SecondArgumentZero_ResultException() {
        Exception ex = assertThrows(Exception.class, () -> calculator.div(2, 0));
        assertEquals("Attempt to divide by zero", ex.getMessage(), "Invalid error message received");
    }

    @DisplayName("Деление целых чисел")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(value = {
            "8000000, 2000000, 4",
            "2, 2, 1",
            "2, -2, -1",
            "0, 2, 0",
            "-6, -2, 3"
    })
    void divide_TwoNumbers(int x, int y, int result) {
        assertEquals(calculator.div(x, y), result);
    }

    @Test
    @DisplayName("Деление дробных чисел")
    void divide_TwoDoubleNumbers() {
        assertEquals(calculator.div(9.0, 2.25), 4);
    }
}
