package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class Em {

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL").createEntityManager();
}
