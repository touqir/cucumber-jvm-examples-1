package uk.co.reisinger.cucumber;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@inheritDoc}
 */
public final class BankAccountImpl implements BankAccount {

    /** account's balance in pence */
    private final AtomicInteger balance;

    /**
     * Creates new account with provided initial balance
     *
     * @param balance initial balanace in pence
     */
    public BankAccountImpl(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int makeWithdrawal(int pence) {
        return balance.addAndGet(pence * -1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int makeDeposit(int pence) {
        return balance.addAndGet(pence);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBalance() {
        return balance.get();
    }

    @Override
    public String toString() {
        return String.format("balance: %d pence", getBalance());
    }
}
