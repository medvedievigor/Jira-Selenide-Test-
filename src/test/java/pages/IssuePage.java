package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class IssuePage {
    private String inputSummaryXpath = "//*[@id=\"summary\"]";
    private String inputDescriptionID = "description"; //"tinymce";
    private String assignToMeButtonXpath = "//*[@id=\"assign-to-me-trigger\"]";
    private String createButtonXpath = "//*[@id=\"create-issue-submit\"]";
    //private String frameXpath = "//*[@id =\"description\"]";
   // private String frameXpath = "//[@class=\"mce-edit-area mce-container mce-panel mce-stack-layout-item mce-first\"]/iframe ";

    public  void enterSummary(String summary){
        $(byXpath(inputSummaryXpath)).sendKeys(summary);

    }
    // Это снячало был iframe, потом они его изменили...
    public  void enterDescription(String description){
           //Selenide.switchTo().frame($(byXpath(frameXpath)));
           $(byId(inputDescriptionID)).sendKeys(description);
           //Selenide.switchTo().defaultContent();
    }

    public void clickAssignToMe(){
        $(byXpath(assignToMeButtonXpath)).click();
    }
    public void clickCreateButton(){
        $(byXpath(createButtonXpath)).click();
    }

}
