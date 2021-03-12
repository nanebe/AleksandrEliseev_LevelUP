package calculator.unit.tests.trigonometric;

import calculator.unit.tests.CalculatorBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CotangensTest extends CalculatorBase {

    @DisplayName("Котангенс числа")
    @ParameterizedTest(name = "ctg({0}) = {1}")
    @CsvSource(value = {
            "45, 0.61",
            "180, 0.74",
            "60, 3.12"
    })
    void cotangensTest(double x, double result) {
        assertEquals(calculator.ctg(x), result, 0.01);
    }
}
