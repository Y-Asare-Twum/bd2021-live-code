package org.example.hrm.dao;

import lombok.extern.log4j.Log4j2;
import org.example.Dao;
import org.example.hrm.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Log4j2
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
        log.debug("updateNameOnDetachedEntity");
        em.getTransaction().begin();

        // Person person = find(p.getId());
        // person.setName(name);
        // // em.persist(person);

        p.setName(name);
        em.merge(p);

        em.getTransaction().commit();
    }

    public List<Person> findByName(String name) {
        TypedQuery<Person> query = em.createQuery("SELECT p from Person p where p.name=:eenNaam", Person.class);
        query.setParameter("eenNaam", name);
        return query.getResultList();
    }

    public List<Person> findAllWithDetails() {
        return em.createQuery(
                "SELECT p " +
                        "FROM Person p " +
                        "JOIN FETCH p.job " + // JOIN FETCH == EAGER
                        "JOIN FETCH p.scrumteam " +
                        "JOIN FETCH p.laptops",
                Person.class).getResultList();
    }

}
