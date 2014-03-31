package uk.co.reisinger.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class BankAccountImplStepdefs {

    private BankAccount bankAccount;

    @Given("^bank account with balance (\\d+) pence$")
    public void bank_account_with_balance_pence(int pence) throws Throwable {
        bankAccount = new BankAccountImpl(pence);
    }

    @When("^I deposit (\\d+) pence$")
    public void I_deposit_pence(int pence) throws Throwable {
        bankAccount.makeDeposit(pence);
    }

    @Then("^the balance should be (\\d+) pence$")
    public void the_balance_should_be_pence(int pence) throws Throwable {
        Assert.assertTrue(bankAccount.getBalance() == pence);
    }

    @Given("^bank account with the following transactions:$")
    public void bank_account_with_the_following_transactions(List<Transaction> transactions) throws Throwable {

        bankAccount = new BankAccountImpl(0);
        for (Transaction transaction : transactions) {
            if (transaction.type.equals("+")) {
                bankAccount.makeDeposit(transaction.pence);
            } else {
                bankAccount.makeWithdrawal(transaction.pence);
            }
        }
    }

    @When("^I make (\\d+)$")
    public void I_make_deposit(int pence) throws Throwable {
        bankAccount.makeDeposit(pence);
    }

    @And("^make (\\d+)$")
    public void make_withdrawal(int pence) throws Throwable {
        bankAccount.makeWithdrawal(pence);
    }

    /**
     * Data Table transformation helper class
     * @see "http://cukes.info/step-definitions.html"
     */
    public class Transaction {
        public String type;
        public int pence;
    }
}
