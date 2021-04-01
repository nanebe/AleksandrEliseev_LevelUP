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

class SeleniumXpathLocatorsTest {

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
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id='q']"));
        searchTextBox.sendKeys("Java");
        SleepUtils.sleep(2000);
    }

    @Test
    void classNameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.xpath("//input[contains(@class, 'search__input')]"));
        searchTextBox.sendKeys("Python");
        SleepUtils.sleep(2000);
    }

    @Test
    void nameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@name='q']"));
        searchTextBox.sendKeys("Php");
        SleepUtils.sleep(2000);
    }

    @Test
    void tagLocatorTest() {
        List<WebElement> spans = driver.findElements(By.xpath("//span"));
        System.out.printf("Amount of spans %d", spans.size());
    }

    @Test
    void otherAttributesLocatorTest() {
        List<WebElement> divs = driver.findElements(By.xpath("//div[@id='search:container']"));
        divs.forEach(div -> System.out.println(div.getText()));
    }

    @Test
    void complexLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id='q']"));
        searchTextBox.sendKeys("Ruby");
        driver.findElement(By.xpath("//button[@id='search:submit']")).click();
        SleepUtils.sleep(2000);
    }
}
