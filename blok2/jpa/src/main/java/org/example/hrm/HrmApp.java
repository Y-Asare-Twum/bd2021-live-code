package org.example.hrm;

import org.example.hrm.dao.PersonDao;
import org.example.hrm.domain.Address;
import org.example.hrm.domain.ContactType;
import org.example.hrm.domain.Person;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class HrmApp {

    public static final EntityManager em = createEntityManagerFactory("MySQL-hrm").createEntityManager();
    private static final PersonDao personDao = PersonDao.instance(em);

    public static void main(String[] args) {
        // See HrmAppIT

        Person p = Person.builder().name("Jan")
                .creationDate(new Date())
                .birthDate(LocalDate.of(1979, 8, 22))
                .birthDateTime(LocalDateTime.of(1979, 8, 22, 6, 10))
                .birthDateTime2(LocalDateTime.of(1979, 8, 22, 6, 10))
                .creationTime(LocalTime.now())
                .hasDriversLicence(true)
                .type(ContactType.Vip)
                .address(Address.builder().street("S").housenumber(32).build())
                .build();

        personDao.save(p);

    }

}
