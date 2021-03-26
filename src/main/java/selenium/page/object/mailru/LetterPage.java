package selenium.page.object.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LetterPage extends AbstractMailRuPage {

    @FindBy(className = "letter-contact")
    private WebElement emailTo;

    @FindBy(className = "thread__subject")
    private WebElement subject;

    @FindBy(xpath = "//div[@class='letter-body']//div[text()]")
    private WebElement message;

    @FindBy(xpath = "//*[text()='Удалить']")
    WebElement delete;

    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailTo() {
        return wait.until(visibilityOf(emailTo)).getAttribute("title");
    }

    public String getSubject() {
        return wait.until(visibilityOf(subject)).getText();
    }

    public String getMessage() {
        return wait.until(visibilityOf(message)).getText();
    }

    public LetterPage deleteLetter() {
        wait.until(elementToBeClickable(delete)).click();
        return this;
    }

}
