package selenium.email;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

class DeleteLetterTest extends EmailBase {

    @Test
    void createAndDeleteLetterTest() {
        emailUtils.createLetter(MY_EMAIL, mailTitle, mailText);
        emailUtils.sendLetter();
        WebElement letter = verifyLetterToMyselfInInbox();
        emailUtils.verifyContent(letter, mailTitle, mailText, MY_EMAIL, emailTo);
        emailUtils.deleteLetter(letter);
        emailUtils.verifyLetterExistInMenu("Корзина", mailText);
    }

    WebElement verifyLetterToMyselfInInbox() {
        driver.findElement(By.partialLinkText("Входящие"))
                .click();
        wait.until(ExpectedConditions.titleContains("Входящие"));
        driver.findElement(By.cssSelector(".mt-t_tomyself"))
                .click();
        String shortBody = mailText.substring(0, 30);
        return driver.findElement(By.xpath(
                String.format("//span[@class='ll-sp__normal'] [contains(., '%s')]", shortBody)));
    }
}
