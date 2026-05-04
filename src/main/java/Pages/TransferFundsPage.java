package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WaitUtil;

public class TransferFundsPage {

    WebDriver driver;
    WaitUtil wait;

    // Constructor (same pattern as RegistrationPage)
    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }

    // Locators using @FindBy

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(id = "toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferBtn;

    @FindBy(id = "showResult")
    WebElement successMsg;

    // Actions

    public void openTransferPage() {
        transferFundsLink.click();
    }

    public void transferAmount(String amount, String from, String to) {
    	
    	wait.waitForVisibility(amountField);
        amountField.sendKeys(amount);

        wait.waitForDropdownOptions(fromAccount);
        new Select(fromAccount).selectByValue(from);
               
        wait.waitForDropdownOptions(toAccount);
        new Select(toAccount).selectByValue(to);
        
        wait.waitForVisibility(transferBtn);

        transferBtn.click();
    }

    public boolean isTransferSuccessful() {
    	
    	wait.waitForVisibility(successMsg);

        return successMsg.getText().contains("Transfer Complete");
        
    }
}