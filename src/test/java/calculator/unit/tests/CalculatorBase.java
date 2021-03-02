package calculator.unit.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorBase {

    protected Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
}
