package selenium.page.object.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MailRuEmailPage extends AbstractMailRuPage {

    @FindBy(xpath = "//*[text()='Написать письмо']")
    WebElement writeLetter;

    public MailRuEmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWriteEmailButtonVisible() {
        return wait.until(visibilityOf(writeLetter))
                .isDisplayed();
    }

    public LetterEditorPage clickToWriteLetter() {
        wait.until(elementToBeClickable(writeLetter)).click();
        return new LetterEditorPage(driver);
    }

}
