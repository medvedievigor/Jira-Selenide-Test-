package test;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import properties.LoadProperties;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;



public class JiraTests {
    public  static IssuePage issuePage;
    public  static DashboardPage dashboardPage;
    public  static SearchPage searchPage;
    public  static  String summary ="test of creating of issue"; //"[Test Automation] QAAUTO6-T1_test01"

    @BeforeTest
    public void setup () {
    LoginPage loginPage = new LoginPage();
    LoadProperties loadProperties =new LoadProperties();
    Configuration.remote ="http://localhost:4444/wd/hub";
    Configuration.browser ="chrome";
    Configuration.timeout = 9000;

    open (loadProperties.getProjectProperty());

            loginPage.enterUserName(loadProperties.getUserName());
            loginPage.enterPassword(loadProperties.getPassword());
            loginPage.clickSubmitButton();

     issuePage = new IssuePage();
     dashboardPage = new DashboardPage();
     searchPage=new SearchPage();
}

        @Test(priority = 1)
        public void CreateIssueTest () {

            dashboardPage.clickCreateIssueButton();

//            CreateIssue createIssue= new CreateIssue();
//            createIssue.enterProjectName("QAAUTO-6 (QAAUT6)");
//            createIssue.enterIssueType("Test");

            issuePage.enterSummary(summary);
            issuePage.enterDescription("Bla-bla-bla");
            issuePage.clickAssignToMe();
            issuePage.clickCreateButton();
        }
            // new test
            @Test(priority = 2)
                    public  void isTaskCreatedTest(){
            String jqlRequestForSearching = "project = QAAUT6 AND assignee = currentUser() AND  summary ~ \"\\\\["+summary+"\\\\]\" ORDER BY createdDate DESC";
            String titleOfSearchedTask =summary;

            dashboardPage.clickIssueButton();
            dashboardPage.clickSearchForIssuesButton();
            searchPage.clickAdvancedButton();
            searchPage.fillJQLField(jqlRequestForSearching);
            searchPage.clickSearchButton();
            try {
                sleep(3000);
            }
            catch (Exception e){}

            Assert.assertTrue($(byXpath("//li[@title =\""+titleOfSearchedTask+"\"]")).isDisplayed(),"This task not exist!");

        }
    }