package selenium.email;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DraftTest extends EmailBase {

    @Test
    void createDraftAndSendItTest() {
        emailUtils.createLetter(emailTo, mailTitle, mailText);
        saveDraft();
        WebElement draft = emailUtils.verifyLetterExistInMenu("Черновики", mailText);
        verifyDraftAndSend(draft);

        emailUtils.verifyElementNotExistFromMenu("Черновики", draft);
        emailUtils.verifyLetterExistInMenu("Отправленные", mailText);
    }

    void saveDraft() {
        driver.findElement(By.cssSelector("span[title='Сохранить']"))
                .click();
        driver.findElement(By.cssSelector("button[title='Закрыть']"))
                .click();
    }

    void verifyDraftAndSend(WebElement draft) {
        draft.click();
        assertEquals(driver.findElement(By.name("Subject")).getAttribute("value"), mailTitle);
        driver.findElement(By.xpath(String.format("//*[text() = '%s']", mailText)));
        assertEquals(driver.findElement(By.cssSelector("div[data-type='to'] span")).getText(), emailTo);
        emailUtils.sendLetter();
    }
}
