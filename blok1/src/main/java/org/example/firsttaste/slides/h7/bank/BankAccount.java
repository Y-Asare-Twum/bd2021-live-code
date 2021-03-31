package org.example.firsttaste.slides.h7.bank;

public class BankAccount {

    private long accountNumber;
    private int balance;
    private double interestRate;

    public BankAccount(long id) {
        this.accountNumber = id;
    }

    /**
     * @return the amount if withdrawal is permitted, 0 otherwise.
     */
    public int withdraw(int amount) {
        if (this.balance - amount > 0) {
            this.balance -= amount;
            return amount;
        } else {
            return 0;
        }
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return balance * Math.pow(1 + interestRate / 100, years);
    }

    // -------------

    @Override
    public String toString() {
        return "Account " + accountNumber + " has balance: " + balance;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
}
