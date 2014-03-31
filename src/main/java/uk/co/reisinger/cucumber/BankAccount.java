package uk.co.reisinger.cucumber;

/**
 * Represents Bank Account. Value of the account is in pence.
 */
public interface BankAccount {

    /**
     * Take money from the account. Amount is in pence.
     *
     * @param pence amount to be taked from the account.
     * @return balance after the withrawal
     */
    int makeWithdrawal(int pence);

    /**
     * Puts money in the account. Amount is in pence.
     *
     * @param pence amount to be deposited.
     * @return balance after the deposit
     */
    int makeDeposit(int pence);

    /**
     * Returns the balance of the account in pence.
     *
     * @return balance in pence.
     */
    int getBalance();
}
