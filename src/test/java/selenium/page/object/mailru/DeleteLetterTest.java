package selenium.page.object.mailru;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteLetterTest extends AbstractMailRuBaseTest {

    @Test
    void createAndDeleteLetterTest() {
        LetterPage letterPage = mailRuEmailPage
                .clickToWriteLetter()
                .enterEmailTo(config.email())
                .enterSubject(randomSubject)
                .enterMessage(randomMessage)
                .send()
                .openFolder("Письма себе")
                .openLetter(randomMessage.substring(0, 30));

        assertEquals(letterPage.getEmailTo(), emailTo);
        assertThat("Некорректная тема письма", letterPage.getSubject().contains(randomSubject));
        assertThat("Некорректная содержимое письма", letterPage.getMessage().contains(randomMessage));

        letterPage
                .deleteLetter()
                .openFolder("Корзина")
                .searchLetter(randomMessage.substring(0, 30));
    }
}
