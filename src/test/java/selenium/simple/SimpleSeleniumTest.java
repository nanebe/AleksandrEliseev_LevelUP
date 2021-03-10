package selenium.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.SleepUtils.sleep;

public class SimpleSeleniumTest {

    private  WebDriver driver;

    @BeforeEach
    void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void simpleOpenMailPageTest() {
        var expectedTitle = "Mail.ru: почта, поиск в интернете, новости, игры";
        driver.navigate().to("https://mail.ru");

        sleep(4000);
        assertEquals(driver.getTitle(), expectedTitle);
    }
}
