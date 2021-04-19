package org.example;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static org.example.Transaction.execute;

public class JdbcExample {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final PersonDao personDao = PersonDao.instance();

    public static void main(String[] args) {
        JdbcExample jdbcExample = new JdbcExample();
        // try {
        //     jdbcExample.jdbcBasic();
        //     jdbcExample.jdbcMore("David");
        //     jdbcExample.jdbcPreparedStatement("David'; DROP TABLE PERSON --"); // SQL injection
        //     jdbcExample.jdbcTransactionMonad("Bart");
        // } catch (SQLException throwables) {
        //     throwables.printStackTrace();
        // }
        jdbcExample.findOnDao();
        jdbcExample.save(Person.builder().name("Abraham").age(50).build());
    }

    private void jdbcBasic() throws SQLException {
        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // Not needed anymore since Java 6 (JDBC4)
        // "Java6 (and JDBC4) introduced a concept known as "service provider" where implementations of known interfaces can be detected by the JVM during startup."
        // https://stackoverflow.com/questions/28220724/class-fornamejdbc-driver-no-longer-needed

        // 2
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //                                                       http        ://host      :port/<path>
        // 3
        Statement statement = connection.createStatement();

        // 4
        ResultSet result = statement.executeQuery("SELECT * FROM PERSON");

        List<Person> persons = new LinkedList<>();
        // 5
        while (result.next()) {
            String n = result.getString("name");
            int a = result.getInt("age");

            Person p =
                    Person.builder()
                            .id(result.getLong("id"))
                            .name(n)
                            .age(a)
                            .build();

            persons.add(p);
        }

        // 6
        statement.close();
        connection.close();
    }

    private void jdbcMore(String eenNaam) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT id AS i FROM person WHERE name='" + eenNaam + "'");
            if (rs.next()) {
                int id = rs.getInt("i");
                statement.executeUpdate("UPDATE PERSON set name = 'Something' WHERE id=" + id);
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 1) Protects against SQL injection AND
     * 2) performs better than normal Statement.
     *
     * @param arg
     * @throws SQLException
     */
    private void jdbcPreparedStatement(String arg) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            // ResultSet rs = statement.executeQuery("SELECT id AS i FROM person WHERE name='" + eenNaam + "'");
            PreparedStatement ps = connection.prepareStatement("SELECT id AS i FROM person WHERE name=?");
            ps.setString(1, arg);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("i");
                statement.executeUpdate("UPDATE PERSON set name = 'Something' WHERE id=" + id);
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private void jdbcTransactionMonad(String arg) {
        execute(connection -> {
            try {
                Statement statement = connection.createStatement();

                // ResultSet rs = statement.executeQuery("SELECT id AS i FROM person WHERE name='" + eenNaam + "'");
                PreparedStatement ps = connection.prepareStatement("SELECT id AS i FROM person WHERE name=?");
                ps.setString(1, arg);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("i");
                    statement.executeUpdate("UPDATE PERSON set name = 'Something' WHERE id=" + id);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void findOnDao() {
        List<Person> people = personDao.findAll();
        people.forEach(System.out::println);

        Person p = personDao.find(1);
        System.out.println(p);
    }

    private void save(Person p) {
        
    }

}
