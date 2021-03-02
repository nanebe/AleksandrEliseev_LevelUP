package calculator.unit.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleTest extends CalculatorBase {

    @Test
    @Disabled
    void multiple_TwoDoubleNumbers() {
        assertEquals(calculator.mult(2.2, 3.0), 6.6);
    }

    @Test
    void multipleLongTest() {
        assertEquals(calculator.mult(2_000_000, 1000), 2_000_000_000);
    }

    @Test
    void multiple_TwoNegativeNumbers_ResultPositive() {
        assertEquals(calculator.mult(-4, -4), 16);
    }

    @Test
    void multiple_OneArgumentZero_ResultZero() {
        assertEquals(calculator.mult(2, 0), 0);
    }

    @TestFactory
    @DisplayName("Умножение двух позитивных чисел не дает отрицательный результат")
    Stream<DynamicTest> multiple_TwoIntPositive_ResultNotNegative() {
        return Stream.generate(Math::random)
                .limit(5)
                .mapToInt(v -> (int) (v * 1000))
                .mapToObj(i -> DynamicTest.dynamicTest("testing multiple operation for values " + i,
                        () -> assertTrue(calculator.mult(i, i) >= 0)));
    }
}
