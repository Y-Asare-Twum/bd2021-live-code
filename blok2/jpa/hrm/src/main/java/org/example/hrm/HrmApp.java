package org.example.hrm;

import org.example.hrm.dao.PersonDao;
import org.example.hrm.domain.Address;
import org.example.hrm.domain.ContactType;
import org.example.hrm.domain.Laptop;
import org.example.hrm.domain.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.example.Em.em;

public class HrmApp {

    private static final PersonDao personDao = PersonDao.instance(em);

    public static void main(String[] args) {
        // See HrmAppIT

        Person p = Person.builder().name("Jan")
                .birthDate(LocalDate.of(1979, 8, 22))
                .birthDateTime(LocalDateTime.of(1979, 8, 22, 6, 10))
                .creationDate(new Date())
                .creationTime(LocalTime.now())
                .hasDriversLicence(true)
                .type(ContactType.Vip)
                .address(Address.builder().street("S").housenumber(32).build())
                .build();

        p.addLaptop(Laptop.builder().brand("DELL").build());

        personDao.save(p);

    }

}
