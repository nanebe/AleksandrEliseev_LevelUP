package calculator.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest extends CalculatorBase {

    @Test
    public void subDoubleTest() {
        assertEquals(calculator.sub(2.4, 2.2), 0.2, 0.001);
    }

    @Test
    public void subLongTest() {
        assertEquals(calculator.sub(2_001_000, 1000), 2_000_000);
    }

    @Test
    public void subNegativeNumbersTest() {
        assertEquals(calculator.sub(-4, -4), 0);
    }
}
