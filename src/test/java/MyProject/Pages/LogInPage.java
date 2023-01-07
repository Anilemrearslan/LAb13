package MyProject.Pages;

import MyProject.Utils.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }
//In Login page check text "Guru99 Bank" is present
    @FindBy(css = "h2[class='barone']")
    public WebElement Guru99BankText;

    public String checkText(){
        return Guru99BankText.getText();
    }

//  Login into application with given credentials
    @FindBy(xpath = "//input[@name='uid']")
    public WebElement UserIDBox;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement PassWordBox;

    @FindBy(xpath = "//input[@name='btnLogin']")
    public WebElement LogInButton;

    public void LogInGuru99(String userid, String passWord){
        UserIDBox.sendKeys(userid);
        PassWordBox.sendKeys(passWord);
        LogInButton.click();
    }

}
