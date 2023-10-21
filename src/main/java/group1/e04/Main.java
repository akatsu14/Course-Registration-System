package group1.e04;

import java.sql.Connection;

import group1.e04.config.JdbcMysqlConnection;

public class Main {

    private static Connection connection = JdbcMysqlConnection.connectDataSource();

    public static void main(String[] args) {
    }
}