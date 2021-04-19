package org.example;

public class JpaApp {

    public static void main(String[] args) {
        new JpaApp().start();
    }

    private void start() {
        PersonDao personDao = PersonDao.INSTANCE;

        Person person = personDao.find(1);
        System.out.println(person);

        Person piet = Person.builder().name("Piet").age(42).build();
        personDao.save(piet);

    }
}
