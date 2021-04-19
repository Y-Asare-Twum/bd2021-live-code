package org.example.hrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaApp {

    private Logger log = LoggerFactory.getLogger(JpaApp.class);

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-pubs").createEntityManager();

    public static void main(String[] args) {
        new JpaApp().start();
    }

    private void start() {
        PersonDao personDao = PersonDao.instance(em);

        Person person = personDao.find(1);
        System.out.println(person);

        Person p = Person.builder().name("Piet").age(42).build();
        personDao.save(p);

        // findAll
        log.debug("all persons:");
        personDao.findAllNamed().forEach(ps -> log.debug(ps.toString()));

        // updating:
        personDao.updateName(p, "Arie");

        em.clear(); // flush & empty cache (=PersistenceContext)

        // piet is now detached, i.e. "cold", i.e. not live connected to db
        personDao.updateNameOnDetachedEntity(p, "Thomas");

        p.setName("Harry");
        Person updatedP = personDao.update(p);

        // remove TODO
        personDao.remove(p);
    }
}
