package org.example.java11.labs.tdd2mocking;

public class TrajectEenhedenNaarPrijsService {

    public int getPriceTrajectEenheden(int aantalTrajectEenheden) {
        return aantalTrajectEenheden * 2;
    }

    public int getPriceTrajectEenheden(String aantalTrajectEenheden) {
        return Integer.parseInt(aantalTrajectEenheden) * 3;
    }
}
