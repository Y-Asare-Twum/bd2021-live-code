package org.example.firsttaste.slides.h7.bank;

import java.util.Iterator;

public class Bank implements Iterable<BankAccount> {

    private AccountManager accountManager = new AccountManager();
    private long id = 10L;
    private String name;

    public Bank(String eenName) {
        this.name = eenName;
    }

    public BankAccount search(long nr) {
        return accountManager.search(nr);
    }

    public void addAccount(BankAccount a) {
        accountManager.addAccount(a);
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        accountManager.transfer(from, to, amount);
    }

    public String accountsToString() {
        StringBuilder sb = new StringBuilder();

        for (BankAccount account : accountManager.getAccounts()) {
            sb.append(account).append("\n");
        }
        sb.append("Total is: ");
        sb.append(getTotal());
        sb.append("\n");
        sb.append("\n");

        return sb.toString();
    }

    public long getTotal() {
        long total = 0;
        for (BankAccount account : accountManager.getAccounts()) {
            total += account.getBalance();
        }
        return total;
    }

    @Override
    public Iterator<BankAccount> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < accountManager.getAccounts().size();
            }

            @Override
            public BankAccount next() {
                // BankAccount bankAccount = accounts.get(index);
                // index++;
                // return bankAccount;

                return accountManager.getAccounts().get(index++);
            }
        };
    }
}
