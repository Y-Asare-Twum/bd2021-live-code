package org.example.hrm;

import lombok.extern.log4j.Log4j2;
import org.example.hrm.dao.LaptopDao;
import org.example.hrm.dao.PersonDao;
import org.example.hrm.dao.TeamDao;
import org.example.hrm.domain.Job;
import org.example.hrm.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Log4j2
public class HrmApp {

    private final EntityManager em =
            Persistence.createEntityManagerFactory("MySQL-hrm").createEntityManager();

    private final PersonDao personDao = PersonDao.instance(em);
    private final TeamDao teamDao = TeamDao.instance(em);
    private final LaptopDao laptopDao = LaptopDao.instance(em);

    public static void main(String[] args) {
        HrmApp hrmApp = new HrmApp();
        hrmApp.persons();
        hrmApp.laptopsLazy();
        hrmApp.updateBidi();
    }

    private void persons() {

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

        try {
            Person piet = Person.builder().name("Piet".repeat(100)).age(42).build();
            personDao.save(piet);
        } catch (Exception e) {
            log.warn("Person not saved: " + e.getCause().getMessage());
        }
    }

    private void laptopsLazy() {
        // Person person = personDao.findByName("Bram").get(0);
        // person.getLaptops().forEach(System.out::println);

        // log.debug("personDao.findByName(\"Bram\")");
        // List<Person> people = personDao.findByName("Bram");

        // log.debug("System.out.println(person.toString())");
        // for (Person person : people) {
        //     System.out.println(person.toString());
        // }

        // log.debug("showing laptops:");
        // people.stream()
        //         .peek(System.out::println)
        //         .map(Person::getLaptops)
        //         .flatMap(Collection::stream)
        //         .forEach(System.out::println);

        List<Person> allWithDetails = personDao.findAllWithDetails();
        allWithDetails.forEach(System.out::println);

    }

    private void updateBidi() {
        Person bram = personDao.findByName("Bram").get(0);
        bram.setScrumteam(teamDao.find(1L));
        personDao.update(bram);
    }
}
