package selenium.email;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

class RuleTest extends EmailBase {

    @Test
    void shouldLetterRedirectWhenExistsRuleIfTitleContainWordTest() {
        mailTitle = mailTitle + " тест";
        emailUtils.createLetter(emailTo, mailTitle, mailText);
        emailUtils.sendLetter();

        emailUtils.verifyLetterExistInMenu("Отправленные", mailText);
        WebElement letter = emailUtils.verifyLetterExistInMenu("Тест", mailText);
        emailUtils.verifyContent(letter, mailTitle, mailText, MY_EMAIL, emailTo);;
    }
}
