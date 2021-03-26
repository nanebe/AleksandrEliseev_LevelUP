package selenium.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public EmailUtils(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    void login(String user, String password) {
        driver.findElement(By.name("login"))
                .sendKeys(user);
        driver.findElement(By.cssSelector("[data-testid='enter-password']"))
                .click();
        driver.findElement(By.name("password"))
                .sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid='login-to-mail']"))
                .click();
        wait.until(ExpectedConditions.titleContains("Почта Mail.ru"));
    }

    void logout() {
        driver.findElement(By.id("PH_logoutLink")).click();
    }

    void createLetter(String email, String title, String message) {
        driver.findElement(By.xpath("//*[text() = 'Написать письмо']"))
                .click();
        driver.findElement(By.cssSelector("div[data-name='to'] input"))
                .sendKeys(email);
        driver.findElement(By.name("Subject"))
                .sendKeys(title);
        driver.findElement(By.cssSelector("div[role='textbox'] > div > br"))
                .sendKeys(message);
    }

    void sendLetter() {
        driver.findElement(By.cssSelector("span[title='Отправить']"))
                .click();
        driver.findElement(By.className("button2_close"))
                .click();
    }

    WebElement verifyLetterExistInMenu(String menuName, String mailTextOrPart) {
        driver.findElement(By.partialLinkText(menuName))
                .click();
        wait.until(ExpectedConditions.titleContains(menuName));
        String shortBody = mailTextOrPart.substring(0, 30);
        return driver.findElement(By.xpath(
                String.format("//span[@class='ll-sp__normal'] [contains(., '%s')]", shortBody)));
//        return driver.findElement(By.xpath(
//                String.format("//div[@class='llc__content'][*/span[@class='llc__subject']/span[text() = '%s'] " +
//                        "and *[contains(.,'%s')] " +
//                        "and */span[@class='ll-crpt'][text() = '%s']]", mailTitle, shortBody, emailTo)));
    }

    void verifyElementNotExistFromMenu(String menuName, WebElement element) {
        driver.findElement(By.partialLinkText(menuName))
                .click();
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    void deleteLetter(WebElement letter) {
        driver.findElement(By.cssSelector("span[title='Удалить']")).click();
        wait.until(ExpectedConditions.invisibilityOf(letter));
    }

    public void verifyContent(WebElement letter, String expTitle, String expText, String expEmailFrom, String expEmailTo) {
        letter.click();
        assertEquals(driver.findElement(By.className("thread__subject")).getText(), expTitle, "Заголовок письма");
        driver.findElement(By.xpath(String.format("//div[@class='letter-body']//*[text() = '%s']", expText)));
        assertEquals(driver.findElement(By.cssSelector(".letter__author > .letter-contact")).getAttribute("title"), expEmailFrom,  "Отправитель письма");
        assertEquals(driver.findElement(By.cssSelector(".letter__recipients > .letter-contact")).getAttribute("title"), expEmailTo,  "Получатель письма");
    }
}
