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

//    String ActualText = DriverUtil.getDriver().findElement(By.xpath("//table[@align= 'center']/tbody/tr[3]/td")).getText();
//    String Expected = "Manger Id : mngr469688";
//
//        Assert.assertTrue(ActualText.contains(Expected),"Home Page Doesn't contains text as \"Manger Id : mngr469688\" , verification has Failed");
//
//        System.out.println("Home Page contains text as \"Manger Id : mngr469688\" , verification has passed");


    public boolean verifyManagerText(){
        return ManagerIDText.getText().equals("Manger Id : mngr469688");
    }

}
