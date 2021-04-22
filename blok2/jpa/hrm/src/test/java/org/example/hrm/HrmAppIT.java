package org.example.hrm;

import org.example.hrm.dao.LaptopDao;
import org.example.hrm.dao.PersonDao;
import org.example.hrm.dao.TeamDao;
import org.example.hrm.domain.Job;
import org.example.hrm.domain.Laptop;
import org.example.hrm.domain.Person;
import org.example.hrm.domain.Team;
import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HrmAppIT {

    public static final EntityManager em = Persistence.createEntityManagerFactory("H2-hrm").createEntityManager();

    private static final PersonDao personDao = PersonDao.instance(em);
    private static final TeamDao teamDao = TeamDao.instance(em);
    private static final LaptopDao laptopDao = LaptopDao.instance(em);

    private static Person p;
    private static Team scrumteam;

    @BeforeAll
    static void beforeAll() {
        p = Person.builder().name("Piet").age(42).build();
        personDao.save(p);
        personDao.save(Person.builder().name("Bram").build());

        laptopDao.save(Laptop.builder().brand("A").build());
        laptopDao.save(Laptop.builder().brand("B").build());
        laptopDao.save(Laptop.builder().brand("C").build());

        scrumteam = Team.builder().yell("Scrum!").build();
        teamDao.save(scrumteam);
    }

    @After
    public void teardown() {
        // If some tests have open transactions because of exceptions (like in validatePerson)
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Test
    void persons() {
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

    @Test
    void laptopsLazy() {
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

        // List<Person> allWithDetails = personDao.findAllWithDetails();
        // allWithDetails.forEach(System.out::println);

        List<Person> all = personDao.findAll();
        for (Person person : all) {
            for (Laptop laptop : person.getLaptops()) {
                System.out.println(laptop);
            }

        }

    }

    @Test
    void updateBidi() {
        Person bram = personDao.findByName("Bram").get(0);
        bram.setScrumteam(scrumteam);
        personDao.update(bram);
    }

    @Test
    void cascadePersistOnLaptop() {
        Person bram = personDao.findByName("Bram").get(0);
        int size1 = bram.getLaptops().size();

        bram.addLaptop(Laptop.builder().brand("DELL").build());
        personDao.update(bram);

        bram = personDao.findByName("Bram").get(0);
        int size2 = bram.getLaptops().size();

        assertThat(size2).isGreaterThan(size1);

    }
}
