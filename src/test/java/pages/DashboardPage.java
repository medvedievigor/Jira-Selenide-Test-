package pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

       private String createNewIssueButtonXpath = "//*[@id=\"create_link\"]";

       public  void clickCreateIssueButton() {
        $(byXpath(createNewIssueButtonXpath)).click();
    }

}
