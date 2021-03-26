package selenium.page.object.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractMailRuPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "nav.nav a")
    protected List<WebElement> folderLinks;

    protected AbstractMailRuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected EmailFolderPage openFolder(String folder) {
        for (WebElement folderLink : folderLinks) {
            if (folderLink.getText().contains(folder)) {
                folderLink.click();
                break;
            }
        }
        return new EmailFolderPage(driver);
    }
}
