package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.example.Transaction.executeTransaction;

public class PersonDao {

    private static PersonDao instance = null;

    private PersonDao() { }

    public static PersonDao instance() {
        if (instance == null) {
            instance = new PersonDao();
        }
        return instance;
    }

    public List<Person> findAll() {
        return executeTransaction((connection) -> {
            List<Person> persons = new LinkedList<>();
            try {
                ResultSet result = connection.createStatement().executeQuery("SELECT * FROM PERSON");
                while (result.next()) {
                    persons.add(
                            Person.builder()
                                    .id(result.getLong("id"))
                                    .name(result.getString("name"))
                                    .age(result.getInt("age"))
                                    .build());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return persons;
        });
    }

    public Person find(long id) {
        return executeTransaction((connection) -> {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON where id=?");
                statement.setLong(1, id);
                ResultSet result = statement.executeQuery();

                return Person.builder()
                        .id(result.getLong("id"))
                        .name(result.getString("name"))
                        .age(result.getInt("age"))
                        .build();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public Boolean save(Person p) {
        return executeTransaction(c -> {
            try {
                PreparedStatement statement = c.prepareStatement("INSERT INTO PERSON(name, age) VALUES (?, ?)");
                statement.setString(1, p.getName());
                statement.setInt(2, p.getAge());

                return (statement.executeUpdate() == 1);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

}
