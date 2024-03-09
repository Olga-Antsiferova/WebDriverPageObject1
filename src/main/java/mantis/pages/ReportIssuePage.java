package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = ("//*[@id=\"sidebar\"]/ul/li[3]/a"))
    private WebElement reportIssueButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }
    public void reportIssuePage(String password) {
        reportIssueButton.sendKeys(password);
        reportIssueButton.sendKeys(Keys.ENTER);
    }
}


