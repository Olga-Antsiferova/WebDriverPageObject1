package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.assertj.core.api.Java6StandardSoftAssertionsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.assertj.core.api.SoftAssertions;

public class IssueTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void countIssue() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();
        int actualIssuesNumber = mantisSite.getViewIssuePage().countIssues();

        Assertions.assertEquals(50, actualIssuesNumber);
    }

    @Test
    public void createDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]//li[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"summary\"]")).sendKeys("16/03/2024");
        driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("description");
        driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]//div[2]/div[2]/input")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"buglist\"]//tr[1]/td[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main-container\"]//div[2]//table//div[10]//input[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"action-group-div\"]/form//div[2]/input")).click();

        WebElement summaryForm = driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[1]/td[11]"));
        String summary = summaryForm.getText();
        Assertions.assertEquals("16/03/2024", summary);
        WebElement viewIssues = driver.findElement(By.xpath("//*[@id=\"bug_action\"]//div[1]/h4"));
        String text = viewIssues.getText();
        Assertions.assertEquals("Viewing Issues 1 - 50 / 19905", text);
    }
}





