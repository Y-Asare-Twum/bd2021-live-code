package org.example.pubs;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

class AuthorDaoIT {

    private final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-pubs").createEntityManager();

    @Test
    void findAll() {
        AuthorDao dao = AuthorDao.instance(em);
        List<Author> all = dao.findAll();
        all.forEach(System.out::println);

    }
}
