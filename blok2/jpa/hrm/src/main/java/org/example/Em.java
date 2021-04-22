package org.example;

import javax.persistence.EntityManager;

import static javax.persistence.Persistence.createEntityManagerFactory;

public final class Em {

    public static final EntityManager em = createEntityManagerFactory("MySQL-hrm").createEntityManager();

}
