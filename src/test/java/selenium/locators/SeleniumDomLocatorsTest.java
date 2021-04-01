package selenium.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SleepUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumDomLocatorsTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://mail.ru");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void idLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.id("q"));
        searchTextBox.sendKeys("Java");
        SleepUtils.sleep(2000);
    }

    @Test
    void classNameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.className("input"));
        searchTextBox.sendKeys("Python");
        SleepUtils.sleep(2000);
    }

    @Test
    void nameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Php");
        SleepUtils.sleep(2000);
    }

    @Test
    void tagLocatorTest() {
        List<WebElement> spans = driver.findElements(By.tagName("span"));
        System.out.printf("Amount of spans %d", spans.size());
    }

    @Test
    void linkTextLocatorTest() {
        WebElement link = driver.findElement(By.linkText("О компании"));
        link.click();
        SleepUtils.sleep(2000);
        assertEquals(driver.getTitle(), "Mail.ru Group");
    }

    @Test
    void partialLinkTextLocatorTest() {
        WebElement link = driver.findElement(By.partialLinkText("О ком"));
        link.click();
        SleepUtils.sleep(2000);
        assertEquals(driver.getTitle(), "Mail.ru Group");
    }
}
