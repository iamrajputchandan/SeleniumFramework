package stepDefinitions;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.TransferFundsPage;
import io.cucumber.java.en.*;

public class TransferFundsSteps {

    LoginPage loginPage;
    TransferFundsPage transferPage;

    @Given("user is logged in for transfer")
    public void loginApp() {

        loginPage = new LoginPage(Hooks.driver);
        loginPage.login("john", "demo");
    }

    @When("user navigates to transfer funds page")
    public void navigateToTransfer() {

        transferPage = new TransferFundsPage(Hooks.driver);
        transferPage.openTransferPage();
    }

    @When("user transfers {string} from account {string} to account {string}")
    public void transferFunds(String amount, String from, String to) {

        transferPage.transferAmount(amount, from, to);
    }

    @Then("transfer should be successful with confirmation message")
    public void verifyTransfer() {

        Assert.assertTrue(transferPage.isTransferSuccessful());
    }
}