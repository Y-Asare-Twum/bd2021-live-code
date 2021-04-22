package org.example;

import javax.persistence.EntityManager;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class Em {
    public static final EntityManager em = createEntityManagerFactory("MySQL-post").createEntityManager();
}
