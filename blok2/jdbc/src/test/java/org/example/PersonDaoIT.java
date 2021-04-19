package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.DatabaseProps.get;

class PersonDaoIT {

    private final PersonDao target = PersonDao.instance();

    @BeforeAll
    static void beforeAll() throws SQLException {

        String script = new BufferedReader(new InputStreamReader(PersonDaoIT.class.getClassLoader().getResourceAsStream("create.sql")))
                .lines().collect(joining());

        Connection c = DriverManager.getConnection(get("url"), get("user"), get("password"));

        Statement s = c.createStatement();
        s.execute(script);

        Person p = Person.builder().name("Tom de Tester").build();

        PreparedStatement ps = c.prepareStatement("INSERT INTO PERSON(name, age) VALUES (?, ?)");
        ps.setString(1, p.getName());
        ps.setInt(2, p.getAge());

        ps.executeUpdate();

    }

    @Test
    void instance() {
        assertThat(target).isInstanceOf(PersonDao.class);
        assertThat(target).isNotNull();
    }

    @Test
    void findAll() {
        // TODO
    }

    @Test
    void find() {
        // todo
    }

    @Test
    void save() {
        List<Person> before = target.findAll();

        target.save(Person.builder().name("Tom de Tester").build());
        List<Person> after = target.findAll();

        assertThat(after.size()).isGreaterThan(before.size());
    }
}
