package Tests;

import Base.BaseTest;
import Pages.LoginPageFactory;
import Pages.RegistrationPage;
import Utils.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

import java.util.Map;

@Listeners({AllureTestNg.class})
public class RegistrationLoginTest extends BaseTest {

    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void registerAndLogin(Map<String, String> data) {

        // 🔹 Initialize pages
        RegistrationPage rp = new RegistrationPage(driver);
        LoginPageFactory lp = new LoginPageFactory(driver);

        // 🔹 Step 1: Register
        reportLog("INFO", "Starting user registration", false);
        rp.registerUser(data);

        // ✅ Assertion for registration
        reportLog("INFO", "Validating registration success", false);
        Assert.assertTrue(
                rp.isRegistrationSuccessful(),
                "Registration failed for user: " + data.get("Username")
        );

        // 🔹 Log PASS (important step → take screenshot)
        reportLog("PASS", "Registration successful for user: " + data.get("Username"), true);

        // 🔹 Step 2: Logout
        reportLog("INFO", "Logging out after registration", false);
        rp.logout();

        // 🔹 Step 3: Login with same credentials
        reportLog("INFO", "Starting login with registered credentials", false);
        lp.login(data);

        // ✅ Assertion for login
        reportLog("INFO", "Validating login success", false);
        Assert.assertTrue(
                lp.isLoginSuccessful(),
                "Login failed for user: " + data.get("Username")
        );

        // 🔹 Log PASS (important step → take screenshot)
        reportLog("PASS", "Login successful for user: " + data.get("Username"), true);

        System.out.println("SUCCESS: Register + Login done for " + data.get("Username"));
    }
}