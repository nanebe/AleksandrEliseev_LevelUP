package calculator.unit.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTest extends CalculatorBase {

    @DisplayName("Разность двух целых чисел")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 2, -1",
            "5, 6, -1",
            "-5, 3, -8",
            "-5, -3, -2",
            "-5, 8, -13",
            "0, 8, -8",
            "10, 22, -12"})
    void sub_TwoNumbers(int x, int y, int z) {
        assertEquals(calculator.sub(x, y), z);
    }
}
