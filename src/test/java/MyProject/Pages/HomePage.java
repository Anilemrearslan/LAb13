package MyProject.Pages;

import MyProject.Utils.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(xpath = "//table[@align= 'center']/tbody/tr[3]/td")
    public WebElement ManagerIDText;

    public boolean verifyManagerText(){
        return ManagerIDText.getText().equals("Manger Id : mngr469688");
    }

}
