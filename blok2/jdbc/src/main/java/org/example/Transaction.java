package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.example.util.DatabaseProps.get;

public class Transaction {

    private static final String USER = get("user");
    private static final String PASSWORD = get("password");
    private static final String URL = get("url");

    public static <T> T executeTransaction(Function<Connection, T> jdbcCode) {
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

    public static void executeTransaction(Consumer<Connection> jdbcCode) {
        executeTransaction(c -> {jdbcCode.accept(c); return 1;});
    }

}
