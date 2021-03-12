package calculator.unit.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignTest extends CalculatorBase {

    @DisplayName("Проверка, что число положительное")
    @ParameterizedTest
    @CsvSource(value = {
            "2, true",
            "0, false",
            "5, true",
            "-5, false",
            "111111115, true"
    })
    void isPositiveNumberTest(int x, boolean result) {
        assertEquals(calculator.isPositive(x), result);
    }

    @DisplayName("Проверка, что число отрицательное")
    @ParameterizedTest
    @CsvSource(value = {
            "2, false",
            "0, false",
            "5, false",
            "-5, true",
            "-111111115, true"
    })
    void isNegativeNumberTest(int x, boolean result) {
        assertEquals(calculator.isNegative(x), result);
    }
}
