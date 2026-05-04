package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.*;

import Utils.WaitUtil;

public class AccountsOverviewPage {

    WebDriver driver;
    WaitUtil wait;

    // Constructor
    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);   // initialize reusable wait
    }

    // Locators using PageFactory

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverviewLink;

    @FindBy(id = "accountTable")
    WebElement accountTable;

    @FindBy(xpath = "//table[@id='accountTable']/tbody/tr")
    List<WebElement> tableRows;

    // Actions

    // Navigate to Accounts Overview page
    public void openAccountsOverview() {
        accountsOverviewLink.click();

        // Wait until table is visible
        wait.waitForVisibility(accountTable);
        wait.waitForAllElements(tableRows);
    }

    // Fetch and print all account details
    public void printAccountDetails() {

        for (WebElement row : tableRows) {

            List<WebElement> cols = row.findElements(By.tagName("td"));

            String accountNumber = cols.get(0).getText();
            String balance = cols.get(1).getText();

            System.out.println("Account: " + accountNumber + " | Balance: " + balance);
        }
    }

    // Return account details in Map (Account → Balance)
    public Map<String, String> getAccountDetails() {

        Map<String, String> accountData = new HashMap<>();

        for (WebElement row : tableRows) {

            List<WebElement> cols = row.findElements(By.tagName("td"));

            String accountNumber = cols.get(0).getText();
            String balance = cols.get(1).getText();

            accountData.put(accountNumber, balance);
        }

        return accountData;
    }

    // Validate at least one account exists
    public boolean isAccountDataPresent() {
        return tableRows.size() > 0;
    }
}