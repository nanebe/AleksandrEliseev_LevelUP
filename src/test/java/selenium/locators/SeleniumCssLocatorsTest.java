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

class SeleniumCssLocatorsTest {

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
        WebElement searchTextBox = driver.findElement(By.cssSelector("#q"));
        searchTextBox.sendKeys("Java");
        SleepUtils.sleep(2000);
    }

    @Test
    void classNameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.cssSelector(".input"));
        searchTextBox.sendKeys("Python");
        SleepUtils.sleep(2000);
    }

    @Test
    void nameLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.sendKeys("Php");
        SleepUtils.sleep(2000);
    }

    @Test
    void tagLocatorTest() {
        List<WebElement> spans = driver.findElements(By.cssSelector("span"));
        System.out.printf("Amount of spans %d", spans.size());
    }

    @Test
    void otherAttributesLocatorTest() {
        List<WebElement> divs = driver.findElements(By.cssSelector("div[id='search:container']"));
        divs.forEach(div -> System.out.println(div.getText()));
    }

    @Test
    void complexLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.cssSelector("#q"));
        searchTextBox.sendKeys("Ruby");
        driver.findElement(By.cssSelector("button.search__btn")).click();
        SleepUtils.sleep(2000);
    }

    @Test
    void cascadeSearchTest() {
        WebElement menu = driver.findElement(By.cssSelector("div.svelte-ogpd9z"));
        List<WebElement> menuItems = menu.findElements(By.cssSelector(".tabs__item"));
//        List<WebElement> menuItems = driver.findElements(By.cssSelector("div.svelte-ogpd9z > .tabs__item"));  // быстрее
        for (WebElement menuItem : menuItems) {
            if ("Игры".equals(menuItem.getText())) {
                menuItem.click();
                break;
            }
        }
        SleepUtils.sleep(3000);
    }
}
