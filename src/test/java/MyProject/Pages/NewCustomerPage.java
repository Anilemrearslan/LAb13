package MyProject.Pages;

import MyProject.Utils.DriverUtil;
import MyProject.Utils.PropertiesReadingUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Scanner;

public class NewCustomerPage {

    public NewCustomerPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='name']")
    public WebElement NameBox;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement RadioButtonMale;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement RadioButtonFemale;

    @FindBy(id = "dob")
    public WebElement DateOfBirth;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement AddressBox;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement CityBox;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement StateBox;

    @FindBy(xpath = "//input[@name='pinno']")
    public WebElement PIN_Box;

    @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement PhoneNumberBox;

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement EMailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement PassWordBox;

    @FindBy(xpath = "//input[@name='sub']")
    public WebElement SubmitButton;

    Faker faker = new Faker();


    public void PersonalInfo(String name , String gender , String BirthDay){
        NameBox.sendKeys(name);
        if (PropertiesReadingUtil.getProperties("Gender").equalsIgnoreCase("male")){
            RadioButtonMale.click();
        }else {
            RadioButtonFemale.click();
        }
        DateOfBirth.sendKeys(BirthDay);


    }

    public void AddressInfo(String Address, String city , String state){
        AddressBox.sendKeys(Address);
        CityBox.sendKeys(city);
        StateBox.sendKeys(state);
    }

    public void AccountInfo(String PIN, String MobileNumber, String eMail, String PassWord){
        PIN_Box.sendKeys(PIN);
        PhoneNumberBox.sendKeys(MobileNumber);
        EMailBox.sendKeys(faker.internet().emailAddress());
        PassWordBox.sendKeys(PassWord);
        SubmitButton.click();
    }



}
