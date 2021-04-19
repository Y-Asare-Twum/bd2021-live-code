package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public enum PersonDao {

    INSTANCE;

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-jpademo").createEntityManager();

    public Person find(long id) {
        return em.find(Person.class, id);
    }

    public void save(Person p) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(p);
        transaction.commit();
    }

}
