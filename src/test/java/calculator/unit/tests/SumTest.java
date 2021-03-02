package calculator.unit.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends CalculatorBase {

    @Test
    public void sumDoubleTest() {
        assertEquals(calculator.sum(2.4, 2.4), 4.8);
    }

    @Test
    public void sumLongTest() {
        assertEquals(calculator.sum(2_000_000, 1000), 2_001_000);
    }

    @Test
    public void sumNegativeNumbersTest() {
        assertEquals(calculator.sum(-4, -4), -8);
    }
}
