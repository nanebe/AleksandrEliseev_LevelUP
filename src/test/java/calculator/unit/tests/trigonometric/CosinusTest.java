package calculator.unit.tests.trigonometric;

import calculator.unit.tests.CalculatorBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CosinusTest extends CalculatorBase {

    @DisplayName("Косинус числа")
    @ParameterizedTest(name = "cos({0}) = {1}")
    @CsvSource(value = {
            "45, 0.52",
            "180, -0.59",
            "60, -0.95",
            "0, 1",
    })
    void cosinusTest(double x, double result) {
        assertEquals(calculator.cos(x), result, 0.01);
    }
}
