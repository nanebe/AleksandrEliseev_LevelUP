package selenium.page.object.mailru;

import config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.AbstractSeleniumBaseTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractMailRuBaseTest extends AbstractSeleniumBaseTest {

    protected TestConfig config;
    protected String emailTo;
    protected String randomSubject;
    protected String randomMessage;
    protected MailRuEmailPage mailRuEmailPage;
    protected MailRuMainPage mailRuMainPage;

    @BeforeEach
    void setUp() {
        config = ConfigFactory.create(TestConfig.class);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        mailRuMainPage = new MailRuMainPage(driver);
        mailRuEmailPage = mailRuMainPage
                .open()
                .enterEmail(config.emailLogin())
                .clickToEnterPassword()
                .enterPassword(config.emailPassword())
                .clickToLogin();

        assertTrue(mailRuEmailPage.isWriteEmailButtonVisible());

        emailTo = config.email();
        randomSubject = "Заголовок письма " + RandomStringUtils.randomNumeric(8);
        randomMessage = "Тело письма " + RandomStringUtils.randomAlphabetic(100);
    }

    @AfterEach
    void logout() {
        mailRuMainPage.clickToLogout();
        driver.quit();
    }

}
