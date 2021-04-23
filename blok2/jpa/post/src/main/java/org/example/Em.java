package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Em {
    public static final String manyToOneUni = "manyToOneUni";
    public static final String manyToOneBidi = "manyToOneBidi";
    public static final String oneToManyUni = "oneToManyUni";
    public static final String oneToManyBidi = "oneToManyBidi";

    public static EntityManager em(String name) {
        return Persistence.createEntityManagerFactory(name).createEntityManager();
    }

    public static void dropAndCreateDatabase(EntityManager em) {
        em.getTransaction().begin();
        em.createNativeQuery("DROP DATABASE IF EXISTS POST").executeUpdate();
        em.createNativeQuery("CREATE DATABASE IF NOT EXISTS POST").executeUpdate();
        em.getTransaction().commit();
    }

    public static <T> void persist(EntityManager em, T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

}
