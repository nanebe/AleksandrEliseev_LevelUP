package calculator.unit.tests.trigonometric;

import calculator.unit.tests.CalculatorBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinusTest extends CalculatorBase {

    @DisplayName("Синус числа")
    @ParameterizedTest(name = "sin({0}) = {1}")
    @CsvSource(value = {
            "45, 0.85",
            "180, -0.8",
            "60, -0.3",
            "0, 0",
    })
    void sinusTest(double x, double result) {
        assertEquals(calculator.sin(x), result, 0.01);
    }
}
