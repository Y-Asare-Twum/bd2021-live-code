package org.example.hrm;

import org.example.hrm.dao.LaptopDao;
import org.example.hrm.dao.PersonDao;
import org.example.hrm.dao.TeamDao;
import org.example.hrm.domain.Job;
import org.example.hrm.domain.Person;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HrmAppIT {

    private final EntityManager em =
            Persistence.createEntityManagerFactory("H2-hrm").createEntityManager();

    private final PersonDao personDao = PersonDao.instance(em);
    private final TeamDao teamDao = TeamDao.instance(em);
    private final LaptopDao laptopDao = LaptopDao.instance(em);

    @Test
    void persons() {
        Person p = Person.builder().name("Piet").age(42).build();
        personDao.save(p);

        Person person = personDao.find(p.getId());

        // findAll
        List<Person> all = personDao.findAll();

        // updating:
        personDao.updateName(p, "Arie");

        em.clear(); // flush & empty cache (=PersistenceContext)

        // piet is now detached, i.e. "cold", i.e. not live connected to db
        personDao.updateNameOnDetachedEntity(p, "Thomas");

        p.setName("Harry");
        Person updatedP = personDao.update(p);

        Job java = Job.builder().title("Javaprogrammeur").build();
        // jobDao.save(java); not needed: cascade = MERGE
        p.setJob(java);
        personDao.update(p);

        teamDao.findAll().forEach(System.out::println);

        // remove
        // personDao.remove(p);

    }

    @Test
    void validatePerson() {
        Person pietLongName = Person.builder().name("Piet".repeat(100)).age(42).build();
        assertThrows(RuntimeException.class, () -> personDao.save(pietLongName));
    }
}
