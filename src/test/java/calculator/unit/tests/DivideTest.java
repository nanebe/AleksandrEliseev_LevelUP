package calculator.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest extends CalculatorBase {

    @Test
    public void divDoubleTest() {
        assertEquals(calculator.div(2.4, 2), 1.2, 0.0001);
    }

    @Test
    public void divLongTest() {
        assertEquals(calculator.div(2_000_000, 1000), 2_000);
    }

    @Test
    public void divNegativeNumbersTest() {
        assertEquals(calculator.div(-4, -4), 1);
    }
}
