package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // ✅ Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Updated Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.xpath("//input[@value='Log In']");
    private By successText   = By.xpath("//h1[contains(text(),'Accounts Overview')]");

    // ✅ Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // ✅ Combined method (best practice)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ✅ Validation
    public boolean isLoginSuccessful() {
        return driver.findElements(successText).size() > 0;
    }
}