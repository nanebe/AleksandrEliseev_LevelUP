package calculator.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultipleTest extends CalculatorBase {

    @Test(enabled = false)
    public void multipleDoubleTest() {
        assertEquals(calculator.mult(2.2, 3), 6.6);
    }

    @Test
    public void multipleLongTest() {
        assertEquals(calculator.mult(2_000_000, 1000), 2_000_000_000);
    }

    @Test
    public void multipleNegativeNumbersTest() {
        assertEquals(calculator.mult(-4, 4), -16);
    }
}
