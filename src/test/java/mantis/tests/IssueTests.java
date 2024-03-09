package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssueTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void createIssue () {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
       mantisSite.getMainPage().goToViewIssuesPage();
       int actualIssuesNumber = mantisSite.getViewIssuePage().countIssues();

        Assertions.assertEquals(50, actualIssuesNumber);
    }
}





