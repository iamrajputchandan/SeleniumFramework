package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.Map;

public class LoginPageFactory {

    WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginBtn;
    
    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement accountOverviewText;

    public void login(Map<String, String> data) {

        username.clear();
        username.sendKeys(data.get("Username"));

        password.clear();
        password.sendKeys(data.get("Password"));

        loginBtn.click();
    }
    
    public boolean isLoginSuccessful() {
        return accountOverviewText.isDisplayed();
    }
}