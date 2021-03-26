package selenium.page.object.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MailRuMainPage extends AbstractMailRuPage {

    private static final String URL = "https://mail.ru/";

    @FindBy(css = "[data-testid='login-input']")
    private WebElement emailInput;

    @FindBy(css = "[data-testid='password-input']")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid='enter-password']")
    private WebElement nextButton;

    @FindBy(css = "[data-testid='login-to-mail']")
    private WebElement loginButton;

    @FindBy(id = "PH_logoutLink")
    WebElement logoutButton;

    public MailRuMainPage(WebDriver driver) {
        super(driver);
    }

    public MailRuMainPage open() {
        driver.navigate().to(URL);
        return this;
    }

    public MailRuMainPage enterEmail(String email) {
        wait.until(visibilityOf(emailInput)).sendKeys(email);
        return this;
    }

    public MailRuMainPage enterPassword(String password) {
        wait.until(visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }

    public MailRuMainPage clickToEnterPassword() {
        wait.until(elementToBeClickable(nextButton)).click();
        return this;
    }

    public MailRuEmailPage clickToLogin() {
        wait.until(elementToBeClickable(loginButton)).click();
        return new MailRuEmailPage(driver);
    }


    public MailRuMainPage clickToLogout() {
        wait.until(elementToBeClickable(logoutButton)).click();
        return new MailRuMainPage(driver);
    }
}
