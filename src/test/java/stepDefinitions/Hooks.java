package stepDefinitions;

import org.openqa.selenium.WebDriver;
import Utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getInstance().getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}