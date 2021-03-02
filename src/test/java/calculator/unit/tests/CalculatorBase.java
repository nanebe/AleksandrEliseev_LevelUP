package calculator.unit.tests;

import org.testng.annotations.BeforeClass;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorBase {

    Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }
}
