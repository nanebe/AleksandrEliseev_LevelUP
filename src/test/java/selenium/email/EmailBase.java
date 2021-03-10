package selenium.email;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class EmailBase {

    protected final String USERNAME = "nanebe7";
    protected final String EMAIL_FROM = USERNAME + "@mail.ru";
    protected final String PASSWORD = "pas20135798";
    protected final String URL = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected EmailUtils emailUtils;

    protected String emailTo;
    protected String mailTitle;
    protected String mailText;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.navigate().to(URL);
        emailUtils = new EmailUtils(driver, wait);

        emailTo = EMAIL_FROM;
        mailText = "Тело письма " + RandomStringUtils.randomAlphabetic(100);
        mailTitle = "Заголовок письма " + RandomStringUtils.randomNumeric(8);

        emailUtils.login();
    }

    @AfterEach
    void tearDown() {
        emailUtils.logout();
        driver.quit();
    }
}
