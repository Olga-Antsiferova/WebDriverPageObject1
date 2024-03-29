package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;


    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public int countIssues() {
        return issues.size();
    }

}
