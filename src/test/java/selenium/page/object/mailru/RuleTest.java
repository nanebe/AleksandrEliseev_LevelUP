package selenium.page.object.mailru;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleTest extends AbstractMailRuBaseTest {

    @Test
    void shouldLetterRedirectWhenExistsRuleIfTitleContainWordTest() {
        String subjectWithTest = randomSubject + " тест";
        LetterPage letterPage = mailRuEmailPage
                .clickToWriteLetter()
                .enterEmailTo(emailTo)
                .enterSubject(subjectWithTest)
                .enterMessage(randomMessage)
                .send()
                .openFolder("Отправленные")
                .searchLetter(randomMessage.substring(0, 30))
                .openFolder("Тест")
                .openLetter(randomMessage.substring(0, 30));

        assertEquals(letterPage.getEmailTo(), emailTo);
        assertThat("Некорректная тема письма", letterPage.getSubject().contains(subjectWithTest));
        assertThat("Некорректная содержимое письма", letterPage.getMessage().contains(randomMessage));
    }
}
