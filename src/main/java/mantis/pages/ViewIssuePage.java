package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = ("a[href='/mantisbt/viewallbugpage.php']"))
    private WebElement viewIssueButton;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void viewIssue(String password) {
       viewIssueButton.sendKeys(password);
        viewIssueButton.sendKeys(Keys.ENTER);
    }
}
