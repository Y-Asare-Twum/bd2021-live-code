package org.example.pubs;

import org.example.hrm.HrmApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PubsApp {

    private final Logger log = LoggerFactory.getLogger(PubsApp.class);

    private static final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-pubs").createEntityManager();

    public static void main(String[] args) {
        new PubsApp().run();
    }

    private void run() {
        AuthorDao dao = AuthorDao.instance(em);
        List<Author> all = dao.findAll();
        all.forEach(System.out::println);
    }

}
