package org.example.java11.slides.h8;

import java.util.Objects;

public class Iban extends BankNumber implements Comparable<Iban> {

    // NL89RABO0315044462
    public final String landcode;
    public final String bankcode;
    public final String rekeningnummer;

    public Iban(String rekNr) {
        this("", "", rekNr);
    }

    private Iban(String landcode, String bankcode, String rekeningnummer) {
        this.landcode = landcode;
        this.bankcode = bankcode;
        this.rekeningnummer = rekeningnummer;
    }

    public static Iban of(String landcode, String bankcode, String rekeningnummer) {
        return new Iban(landcode, bankcode, rekeningnummer);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Iban)) {
            return false;
        }

        // else:
        Iban otherIban = (Iban) other;
        return otherIban.bankcode.equals(this.bankcode) &&
                otherIban.landcode.equals(this.landcode) &&
                otherIban.rekeningnummer.equals(this.rekeningnummer);
    }

    @Override
    public int hashCode() { // Collections, Arrays, Objects = utilility classes
        return Objects.hash(landcode, bankcode, rekeningnummer);
    }

    @Override
    public String toString() {
        return "Iban{" +
                "landcode='" + landcode + '\'' +
                ", bankcode='" + bankcode + '\'' +
                ", rekeningnummer='" + rekeningnummer + '\'' +
                '}';
    }

    public String getBankcode() {
        return bankcode;
    }

    @Override
    public int compareTo(Iban other) {
        // when is this greater than, equal to or smaller than other?

        // if greater, then return a positive int
        if (Integer.parseInt(this.rekeningnummer) > Integer.parseInt(other.rekeningnummer)) {
            return 1;
        }

        // if equal, then return 0
        if (Integer.parseInt(this.rekeningnummer) == Integer.parseInt(other.rekeningnummer)) {
            return 0;
        }

        // if smaller, then return a negative int
        if (Integer.parseInt(this.rekeningnummer) < Integer.parseInt(other.rekeningnummer)) {
            return -1;
        }

        return 0;
    }

}
