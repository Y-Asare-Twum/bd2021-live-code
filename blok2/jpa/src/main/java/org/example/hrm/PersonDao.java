package org.example.hrm;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PersonDao /*extends Dao<Person>*/ {

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-jpademo").createEntityManager();

    private static PersonDao instance;

    // private PersonDao(EntityManager em) {
    //     super(em);
    // }

    public static PersonDao instance(EntityManager em) {
        if (instance == null) {
            instance = new PersonDao();
        }
        return instance;
    }

    public Person find(long id) {
        return em.find(Person.class, id); // SELECT .. WHERE id = ..
    }

    public void save(Person p) {
        em.getTransaction().begin();
        em.persist(p); // INSERT == persist
        em.getTransaction().commit();
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

    public List<Person> findAllNamed() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList(); // JPQL Java Persistence Query Language
    }

    public Person update(Person p) {
        em.getTransaction().begin();
        Person mergedP = em.merge(p);// UPDATE ...
        em.getTransaction().commit();
        return mergedP;
    }

    public void remove(Person p) {
        em.getTransaction().begin();
        em.remove(find(p.getId())); // DELETE ...
        em.getTransaction().commit();
    }
}
