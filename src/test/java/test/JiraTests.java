package test;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;



public class JiraTests {
    public  static IssuePage issuePage;
    public  static DashboardPage dashboardPage;
    public  static SearchPage searchPage;

    @BeforeTest
    public void setup () {
    LoginPage loginPage = new LoginPage();
    Configuration.remote ="http://localhost:4444/wd/hub";
    Configuration.browser ="chrome";
    Configuration.timeout = 9000;

    open ("http://jira.hillel.it:8080/login.jsp");

            loginPage.enterUserName("webinar5");
            loginPage.enterPassword("webinar5");
            loginPage.clickSubmitButton();

     issuePage = new IssuePage();
     dashboardPage = new DashboardPage();
     searchPage=new SearchPage();
}

        @Test(priority = 1)
        public void CcreateIssueTest () {

            dashboardPage.clickCreateIssueButton();

            //CreateIssue createIssue= new CreateIssue();
            //createPage.enterProjectName("QAAUTO-6 (QAAUT6)");
            // createPage.enterIssueType("Test");

            issuePage.enterSummary("test of creating of issue");
            issuePage.enterDescription("Bla-bla-bla");
            issuePage.clickAssignToMe();
            issuePage.clickCreateButton();
        }
            // new test
            @Test(priority = 2)
                    public  void isTaskCreatedTest(){
            String jqlRequestForSearching = "project = QAAUT6 AND assignee = currentUser() AND  summary ~ \"\\\\[Test Automation QAAUTO6-T1_test01\\\\]\" ORDER BY createdDate DESC";
            String titleOfSearchedTask = "[Test Automation] QAAUTO6-T1_test01";

            dashboardPage.clickIssueButton();
            dashboardPage.clickSearchForIssuesButton();
            searchPage.clickAdvancedButton();
            searchPage.fillJQLField(jqlRequestForSearching);
            searchPage.clickSearchButton();
            Assert.assertTrue($(byXpath("//li[1][@title =\""+titleOfSearchedTask+"\"]")).isDisplayed(),"This task not exist!");

        }
    }