package org.example.java11.slides.h13;

public class BakjeApp {
    public static void main(String[] args) {
        BakjeObject b = new BakjeObject();
        b.setInhoud("");

        Object inhoud = b.getInhoud();

        Bakje bakje = new Bakje();
        // Bakje<Object> objectBakje = new Bakje<>();

        // Bakje<Person> personBakje = new Bakje<>();
        // personBakje.setInhoud(new Person());
        // Person inhoud1 = personBakje.getInhoud();

        Bakje<Number> numberBakje = new Bakje<>();
        numberBakje.setInhoud(Double.valueOf(1.0));
        numberBakje.setInhoud(1);
        numberBakje.setInhoud(1f);

        Number inhoud1 = numberBakje.getInhoud();

    }
}
