package org.example.hrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HrmApp {

    private final Logger log = LoggerFactory.getLogger(HrmApp.class);

    private final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-hrm").createEntityManager();

    public static void main(String[] args) {
        new HrmApp().start();
    }

    private void start() {
        PersonDao personDao = PersonDao.instance(em);
        TeamDao teamDao = TeamDao.instance(em);

        Person p = Person.builder().name("Piet").age(42).build();
        personDao.save(p);

        Person person = personDao.find(p.getId());
        log.debug(person.toString());

        // findAll
        log.debug("all persons:");
        personDao.findAll().forEach(ps -> log.debug(ps.toString()));

        // updating:
        personDao.updateName(p, "Arie");

        em.clear(); // flush & empty cache (=PersistenceContext)

        // piet is now detached, i.e. "cold", i.e. not live connected to db
        personDao.updateNameOnDetachedEntity(p, "Thomas");

        p.setName("Harry");
        Person updatedP = personDao.update(p);

        Job java = Job.builder().title("Javaprogrammeur").build();
        // jobDao.save(java);
        p.setJob(java);
        personDao.update(p);

        teamDao.findAll().forEach(System.out::println);

        // remove
        // personDao.remove(p);
    }
}
