package org.example.hrm;

import org.example.Dao;

import javax.persistence.EntityManager;

public class PersonDao extends Dao<Person, Long> {

    private static PersonDao instance;

    private PersonDao(EntityManager em) {
        super(em);
    }

    public static PersonDao instance(EntityManager em) {
        if (instance == null) {
            instance = new PersonDao(em);
        }
        return instance;
    }

    public void updateName(Person p, String name) {
        em.getTransaction().begin();
        p.setName(name);
        em.getTransaction().commit();
    }

    public void updateNameOnDetachedEntity(Person p, String name) {
        em.getTransaction().begin();

        // Person person = find(p.getId());
        // person.setName(name);
        // // em.persist(person);

        p.setName(name);
        em.merge(p);

        em.getTransaction().commit();
    }

}
