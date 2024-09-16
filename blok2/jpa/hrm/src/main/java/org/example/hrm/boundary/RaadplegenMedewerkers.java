package org.example.hrm.boundary;

import org.example.hrm.domain.Person;

import static java.lang.Long.parseLong;
import static org.example.hrm.HrmApp.*;

public class RaadplegenMedewerkers implements Boundary {

    private String zoeknaam = null;

    // singleton design pattern begin -----------
    private static RaadplegenMedewerkers self;

    private RaadplegenMedewerkers() {}

    public static synchronized RaadplegenMedewerkers raadplegenMedewerkers() {
        if (self == null) self = new RaadplegenMedewerkers();
        return self;
    }
    // singleton design pattern end -------------

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle medewerkers: ");

            personDao.findBy(zoeknaam).forEach(e -> System.out.println("\t" + e));

            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Medewerker verwijderen]");
            System.out.println("(2) [Medewerker toevoegen]");
            System.out.println("(3) [Medewerker zoeken]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1":
                    remove(); break;
                case "2":
                    add(); break;
                case "3":
                    search(); break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void remove() {
        System.out.println("Welke medewerker wilt u verwijderen?");
        String id = prompt("Id: ");

        Person employee = personDao.find(parseLong(id));
        if (employee == null) {
            System.out.println("Medewerker " + id + " niet gevonden...");
            return;
        }

        personDao.remove(employee);
        System.out.println("Medewerker " + id + " verwijderd.");
    }

    private void add() {
        System.out.println("Toevoegen medewerker.");
        String naam = prompt("Naam: ");
        personDao.save(Person.builder().name(naam).build());
        System.out.println("Medewerker toegevoegd!");
    }

    private void search() {
        System.out.println("Zoeken medewerker.");
        this.zoeknaam = prompt("Naam: ");
        System.out.println("Resultaten:");
    }
}
