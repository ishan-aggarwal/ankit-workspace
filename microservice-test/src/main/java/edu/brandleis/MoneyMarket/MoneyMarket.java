package edu.brandleis.MoneyMarket;

import java.util.Arrays;

public class MoneyMarket {

    private final double[] accounts;

    /**
     * Constructs the money market.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public MoneyMarket(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(double from, double to, double amount) {
        int fromAcc = (int) from;
        int toAcc = (int) to;

        if(amount <= accounts[fromAcc]) {
            accounts[fromAcc] = accounts[fromAcc] - amount;
            accounts[toAcc] = accounts[toAcc] + amount;
        }
    }

    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public double getTotalBalance() {
        double totalBalance = 0.0;
        for(double balance : accounts) {
            totalBalance += balance;
        }
        return totalBalance;
    }

    public double[] getAccounts() {
        return accounts;
    }
}
