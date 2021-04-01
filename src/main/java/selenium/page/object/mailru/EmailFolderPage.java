package selenium.page.object.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class EmailFolderPage extends AbstractMailRuPage {

    public EmailFolderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLetterElement(String partialMessage) {
        return driver.findElement(
                By.xpath(String.format("//span[@class='ll-sp__normal'] [contains(., '%s')]", partialMessage))
        );
    }

    public EmailFolderPage searchLetter(String partialMessage) {
        getLetterElement(partialMessage);
        return this;
    }

    public LetterPage openLetter(WebElement element) {
        wait.until(elementToBeClickable(element)).click();
        return new LetterPage(driver);
    }

    public LetterPage openLetter(String partialMessage) {
        driver.findElement(
                By.xpath(String.format("//span[@class='ll-sp__normal'] [contains(., '%s')]", partialMessage))).click();
        return new LetterPage(driver);
    }

    public LetterEditorPage openLetterFromDraft(WebElement element) {
        wait.until(elementToBeClickable(element)).click();
        return new LetterEditorPage(driver);
    }

    public EmailFolderPage waitElementIsNotPresent(WebElement element){
        wait.until(invisibilityOf(element));
        return this;
    }

}
