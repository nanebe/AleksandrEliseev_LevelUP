package selenium.page.object.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ESCAPE;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LetterEditorPage extends AbstractMailRuPage {

    @FindBy(css = "div[data-type='to'] input")
    private WebElement emailToInput;

    @FindBy(name = "Subject")
    private WebElement subjectInput;

    @FindBy(css = "span[title='Отправить']")
    private WebElement send;

    @FindBy(css = "span[title='Сохранить']")
    private WebElement save;

    @FindBy(css = "button[title='Закрыть']")
    private WebElement close;

    public LetterEditorPage(WebDriver driver) {
        super(driver);
    }

    public LetterEditorPage enterEmailTo(String email) {
        wait.until(visibilityOf(emailToInput)).sendKeys(email);
        return this;
    }

    public LetterEditorPage enterSubject(String subject) {
        wait.until(visibilityOf(subjectInput)).sendKeys(subject);
        return this;
    }

    public LetterEditorPage enterMessage(String message) {
        wait.until(presenceOfElementLocated(By.cssSelector("div[role='textbox'] br"))).sendKeys(message);
        return this;
    }

    public MailRuEmailPage send() {
        wait.until(visibilityOf(send)).click();
        wait.until(visibilityOfElementLocated(By.xpath("//a[text()='Письмо отправлено']"))).click();
        new Actions(driver).sendKeys(ESCAPE).build().perform();
        return new MailRuEmailPage(driver);
    }

    public MailRuEmailPage close() {
        wait.until(visibilityOf(close)).click();
        return new MailRuEmailPage(driver);
    }

    public LetterEditorPage save() {
        wait.until(visibilityOf(save)).click();
        return this;
    }

    public String getEmailTo() {
        return wait.until(visibilityOfElementLocated(By.cssSelector("div[data-type='to'] span"))).getText();
    }

    public String getSubject() {
        return wait.until(visibilityOf(subjectInput)).getAttribute("value");
    }

    public String getMessage() {
        return wait.until(visibilityOfElementLocated(By.xpath("//div[@role='textbox']//div[text()]"))).getText();
    }

}
