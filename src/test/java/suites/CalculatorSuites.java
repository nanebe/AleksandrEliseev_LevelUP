package suites;

import calculator.unit.tests.DivideTest;
import calculator.unit.tests.MultipleTest;
import calculator.unit.tests.SubTest;
import calculator.unit.tests.SumTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {SumTest.class, MultipleTest.class})
class SumMultCalculatorSuite {
}

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {DivideTest.class, SubTest.class})
class DivSubCalculatorSuite {
}

@RunWith(JUnitPlatform.class)
@SelectPackages(value = {"calculator.unit.tests"})
class AllCalculatorSuite {
}

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Тесты проверки тригонометрических операций")
@SelectPackages(value = {"calculator.unit.tests.trigonometric"})
class TrgFuncCalculatorSuite {
}

@RunWith(JUnitPlatform.class)
@SelectPackages(value = {"calculator.unit.tests"})
@ExcludePackages(value = {"calculator.unit.tests.trigonometric"})
@ExcludeClassNamePatterns(value = {"^.*(Multiple|Divide|Sum|Sub)Test$"})
class OtherCalculatorSuite {
}