package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.Map;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(name = "customer.firstName")
    WebElement firstName;

    @FindBy(name = "customer.lastName")
    WebElement lastName;

    @FindBy(name = "customer.address.street")
    WebElement address;

    @FindBy(name = "customer.address.city")
    WebElement city;

    @FindBy(name = "customer.address.state")
    WebElement state;

    @FindBy(name = "customer.address.zipCode")
    WebElement zipCode;

    @FindBy(name = "customer.phoneNumber")
    WebElement phone;

    @FindBy(name = "customer.ssn")
    WebElement ssn;

    @FindBy(name = "customer.username")
    WebElement username;

    @FindBy(name = "customer.password")
    WebElement password;

    @FindBy(name = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerBtn;
    
    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully')]")
    WebElement successMessage;
    
    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    public void registerUser(Map<String, String> data) {

        registerLink.click();

        firstName.sendKeys(data.get("FirstName"));
        lastName.sendKeys(data.get("LastName"));
        address.sendKeys(data.get("Address"));
        city.sendKeys(data.get("City"));
        state.sendKeys(data.get("State"));
        zipCode.sendKeys(data.get("ZipCode"));
        phone.sendKeys(data.get("Phone"));
        ssn.sendKeys(data.get("SSN"));
        username.sendKeys(data.get("Username"));
        password.sendKeys(data.get("Password"));
        confirmPassword.sendKeys(data.get("Password"));

        registerBtn.click();
    }
    
    public boolean isRegistrationSuccessful() {
        return successMessage.isDisplayed();
    }
    
    public void logout() {
        logoutLink.click();
    }
}