package org.example.firsttaste.slides.h7.bank;

import java.util.Iterator;

public class BankApp {

    public void start() {
        Bank bank = new Bank("Rabo");

        BankAccount a = new BankAccount(1);
        bank.addAccount(a);

        bank.addAccount(new BankAccount(2));
        bank.addAccount(new BankAccount(3));

        try {
            BankAccount searched = bank.search(2); // C+A+V = extract to variable
            System.out.println("Resultaat: ");
            System.out.println(searched);
            System.out.println("Einde...");
        } catch (AccountNotFoundException ex) {
            System.out.println("Foutje! " + ex.getMessage());
        } finally {
            // opruimen van resources. (close op een resource, zoals een verbinding of een file open)
            System.out.println("Done...");
        }

        // iterator usage:

        for (BankAccount account : bank) {
            System.out.println(account);
        }

        // idem:

        Iterator<BankAccount> iterator = bank.iterator();
        while (iterator.hasNext()) {
            BankAccount next = iterator.next();
            System.out.println(next);
        }

    }

}
