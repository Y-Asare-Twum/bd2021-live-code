package org.example;

import javax.persistence.EntityManager;

import static javax.persistence.Persistence.createEntityManagerFactory;

public final class Em {

    // Application managed EntityManager
    public static final EntityManager em = createEntityManagerFactory("MySQL-hrm").createEntityManager();

}
