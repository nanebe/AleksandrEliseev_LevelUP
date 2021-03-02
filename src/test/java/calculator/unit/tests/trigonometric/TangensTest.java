package calculator.unit.tests.trigonometric;

import calculator.unit.tests.CalculatorBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TangensTest extends CalculatorBase {

    @DisplayName("Тангенс числа")
    @ParameterizedTest(name = "tg({0}) = {1}")
    @CsvSource(value = {
            "45, 1.61",
            "180, 1.33",
            "60, 0.32",
            "0, 0",
    })
    void tangensTest(double x, double result) {
        assertEquals(calculator.tg(x), result, 0.01);
    }
}
