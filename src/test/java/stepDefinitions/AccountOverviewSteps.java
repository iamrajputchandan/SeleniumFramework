package stepDefinitions;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.AccountsOverviewPage;
import io.cucumber.java.en.*;

public class AccountOverviewSteps {

    LoginPage loginPage;
    AccountsOverviewPage accountsPage;

    @Given("user is logged in for account overview")
    public void loginApp() {

        loginPage = new LoginPage(Hooks.driver);
        loginPage.login("john", "demo");
    }

    @When("user navigates to accounts overview page")
    public void navigateToAccounts() {

        accountsPage = new AccountsOverviewPage(Hooks.driver);
        accountsPage.openAccountsOverview();
    }

    @Then("account balance should be displayed")
    public void verifyAccountBalance() {

    	accountsPage.printAccountDetails();

        Assert.assertTrue(accountsPage.isAccountDataPresent(),
                "No account data found!");
    }
}