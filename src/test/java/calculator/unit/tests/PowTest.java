package calculator.unit.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowTest extends CalculatorBase {

    @DisplayName("Возведение в степень")
    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @CsvSource(value = {
            "2, 2, 4",
            "0, 5, 0",
            "5, 0, 1",
            "5, 5, 3125",
            "-256, 2, 65536"
    })
    void powTest(int x, int y, int result) {
        assertEquals(calculator.pow(x, y), result);
    }
}
