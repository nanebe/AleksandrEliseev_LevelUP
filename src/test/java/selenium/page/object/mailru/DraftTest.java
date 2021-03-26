package selenium.page.object.mailru;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DraftTest extends AbstractMailRuBaseTest {

    @Test
    void createLetterDraftAndSendItTest() {
        WebElement letter = mailRuEmailPage
                .clickToWriteLetter()
                .enterEmailTo(emailTo)
                .enterSubject(randomSubject)
                .enterMessage(randomMessage)
                .save()
                .close()
                .openFolder("Черновики")
                .getLetterElement(randomMessage.substring(0, 30));

        LetterEditorPage letterPage = new EmailFolderPage(driver).openLetterFromDraft(letter);

        assertEquals(letterPage.getEmailTo(), emailTo);
        assertEquals(letterPage.getSubject(), randomSubject);
        assertEquals(letterPage.getMessage(), randomMessage);

        letterPage
                .send()
                .openFolder("Черновики")
                .waitElementIsNotPresent(letter)
                .openFolder("Отправленные")
                .searchLetter(randomMessage.substring(0, 30));
    }
}
