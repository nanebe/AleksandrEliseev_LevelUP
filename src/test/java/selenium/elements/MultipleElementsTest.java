package selenium.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SleepUtils;

import java.util.List;

public class MultipleElementsTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void multipleElementsTest() {
        driver.navigate().to("https://mail.ru");
        SleepUtils.sleep(2000);

        List<WebElement> elements = driver.findElements(By.cssSelector("[class='tabs__item svelte-ogpd9z']"));
        System.out.printf("WebElements size = %d\n", elements.size());

        WebElement element = driver.findElement(By.cssSelector("[class='tabs__item svelte-ogpd9z']"));
        System.out.printf("WebElement found = %s", element.getText());
    }
}
