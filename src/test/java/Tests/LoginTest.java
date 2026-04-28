package Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.DataProviders;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void loginTest(Map<String, String> testData) {

        // Create Page Object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login using data from DataProvider
        loginPage.login(
                testData.get("Username"),
                testData.get("Password")
        );

        // Validation
        boolean isLoginSuccess = loginPage.isLoginSuccessful();

        // Assertion
        Assert.assertTrue(isLoginSuccess, 
                "Login FAILED for user: " + testData.get("username"));

        // Log (optional)
        System.out.println("PASS: Login successful for " + testData.get("username"));
    }
}