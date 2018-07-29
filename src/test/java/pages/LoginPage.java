package pages;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
        private String userNameInputXpath = "//*[@id=\"login-form-username\"]";
        private String passwordInputXpath = "//*[@id=\"login-form-password\"]";
        private String submitButtonXpath = "//*[@id=\"login-form-submit\"]";

    public  void enterUserName(String userName){
        $(byXpath(userNameInputXpath)).sendKeys(userName);

    }public  void enterPassword(String password){
        $(byXpath(passwordInputXpath)).sendKeys(password);

    }public  void clickSubmitButton (){
        $(byXpath(submitButtonXpath)).click();
        $(submitButtonXpath);
    }
}

