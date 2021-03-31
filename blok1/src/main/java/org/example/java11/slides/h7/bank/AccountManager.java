package org.example.java11.slides.h7.bank;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private List<BankAccount> accounts = new ArrayList<>();

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount search(long nr) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == nr) {
                return account;
            }
        }

        throw new AccountNotFoundException("Account met nummer " + nr + " is niet gevonden!");
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        if (from.withdraw(amount) > 0) {
            to.deposit(amount);
        }
    }

    public long getTotal() {
        long total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }


}
