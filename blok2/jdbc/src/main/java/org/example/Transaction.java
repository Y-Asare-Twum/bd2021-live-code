package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Transaction {

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo?serverTimezone=UTC";

    public static <T> T execute(Function<Connection, T> jdbcCode) {
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            c.setAutoCommit(false);

            T apply = jdbcCode.apply(c);

            c.commit();

            return apply;
        } catch (SQLException e) {
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void execute(Consumer<Connection> jdbcCode) {
        execute(c -> {jdbcCode.accept(c); return 1;});
    }

}
