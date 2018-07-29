package test;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.CreateIssue;
import pages.DashboardPage;
import pages.IssuePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class JiraAddIssue {

        @Test
        public void mainTest () {
            LoginPage loginPage = new LoginPage();
            Configuration.remote="http://localhost:4444/wd/hub";
            Configuration.browser="chrome";
            open("http://jira.hillel.it:8080/login.jsp");

            loginPage.enterUserName("webinar5");
            loginPage.enterPassword("webinar5");
            loginPage.clickSubmitButton();

            IssuePage issuePage=new IssuePage();

            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.clickCreateIssueButton();

            //CreateIssue createIssue= new CreateIssue();
            //createPage.enterProjectName("QAAUTO-6 (QAAUT6)");
           // createPage.enterIssueType("Test");

            issuePage.enterSummary("test of creating of issue");
            issuePage.enterDescription("Bla-bla-bla");
            issuePage.clickAssignToMe();
            issuePage.clickCreateButton();
        }
    }