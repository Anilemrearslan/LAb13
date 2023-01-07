package MyProject.Guru99;

import MyProject.Base.TestBase;
import MyProject.Pages.HomePage;
import MyProject.Pages.LogInPage;
import MyProject.Pages.NewCustomerPage;
import MyProject.Utils.DriverUtil;
import MyProject.Utils.PropertiesReadingUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab13 extends TestBase {

    @Test
    public void TC1(){
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("Guru99_Url"));
        LogInPage logIn = new LogInPage();
        logIn.LogInGuru99(PropertiesReadingUtil.getProperties("UserID"), PropertiesReadingUtil.getProperties("PassWord"));

        //Verify that the Home page contains text as "Manger Id: mngr368294"
        HomePage ManagerText = new HomePage();
        Assert.assertTrue(ManagerText.verifyManagerText(),"Home Page Doesn't contains text as \"Manger Id : mngr469688\" , verification has Failed");
        System.out.println("Home Page contains text as \"Manger Id : mngr469688\" , verification has passed");

        //Click on new customer button and verify you are in New Customer Entry Page
        WebElement newCustomer = DriverUtil.getDriver().findElement(By.linkText("New Customer"));
        newCustomer.click();
        Assert.assertTrue(DriverUtil.getDriver().getTitle().contains("New Customer Entry Page"),"verification has failed");
        System.out.println("you are in New Customer Entry Page , verification has passed");

        NewCustomerPage AddNewCustomer = new NewCustomerPage();
        AddNewCustomer.PersonalInfo(PropertiesReadingUtil.getProperties("CustomerName"),
                PropertiesReadingUtil.getProperties("Gender"),PropertiesReadingUtil.getProperties("DateOfBirth"));

        AddNewCustomer.AddressInfo(PropertiesReadingUtil.getProperties("Address"),
                PropertiesReadingUtil.getProperties("City"),PropertiesReadingUtil.getProperties("State"));
        Faker faker = new Faker();
        AddNewCustomer.AccountInfo(PropertiesReadingUtil.getProperties("PIN"),
                PropertiesReadingUtil.getProperties("MobileNumber"),faker.internet().emailAddress(),
                PropertiesReadingUtil.getProperties("Password"));

        String Confirmation = DriverUtil.getDriver().findElement(By.xpath("//p[@class='heading3']")).getText();
        String ExpectedResult = "Customer Registered Successfully!!!";
        Assert.assertEquals(Confirmation,ExpectedResult,"you are not successfully registered , verification has failed!!!");
        System.out.println("you are successfully registered , verification has passed");




    }
}
