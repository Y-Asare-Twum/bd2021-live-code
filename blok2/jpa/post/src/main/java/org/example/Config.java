package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.Transaction.executeTransaction;

public class Config {
    public static final String manyToOneUni = "manyToOneUni";
    public static final String manyToOneBidi = "manyToOneBidi";
    public static final String oneToManyUni = "oneToManyUni";
    public static final String oneToManyBidi = "oneToManyBidi";

    public static EntityManager em(String name) {
        return Persistence.createEntityManagerFactory(name).createEntityManager();
    }

    public static void dropAndCreateDatabase() {
        executeTransaction(c -> {
            try {
                Statement s = c.createStatement();
                s.execute("DROP DATABASE IF EXISTS POST");
                s.execute("CREATE DATABASE IF NOT EXISTS POST");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static <T> void persist(EntityManager em, T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public static <T> void merge(EntityManager em, T e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    public static void remove(EntityManager em, long id, Class<?> c) {
        em.getTransaction().begin();
        em.remove(em.find(c, id));
        em.getTransaction().commit();
    }

    public static <T> T find(EntityManager em, long id, Class<T> c) {
        em.clear(); // mimic JEE, i.e. entity is detached by default
        return em.find(c, id);
    }

}
