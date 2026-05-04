package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        // Initialize driver
        driver = DriverFactory.getInstance().getDriver("chrome");

        // Maximize window
        driver.manage().window().maximize();

        // Launch application (🔁 replace with your actual URL)
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterMethod
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void reportLog(String level, String message, boolean captureScreenshot, String module) {

        // Log step to Allure
        Allure.step(level + ": " + message + " [" + module + "]");

        // Capture screenshot if needed
        if (captureScreenshot) {
            attachScreenshot();
        }
        
        if (level.equalsIgnoreCase("FAIL")) {
            throw new AssertionError(message);
        }
    }

    // 🔹 Overloaded method (without module)
    public void reportLog(String level, String message, boolean captureScreenshot) {

        Allure.step(level + ": " + message);

        if (captureScreenshot) {
            attachScreenshot();
        }
        
     // 🔥 Fail test ONLY if level is FAIL
        if (level.equalsIgnoreCase("FAIL")) {
            throw new AssertionError(message);
        }
    }

    // 🔥 Screenshot method for Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}