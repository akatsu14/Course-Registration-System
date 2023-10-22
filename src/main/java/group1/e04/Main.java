package group1.e04;

import java.sql.Connection;

import group1.e04.config.JdbcMysqlConnection;
import group1.e04.dao.JdbcAccountRepository;
import group1.e04.dao.JdbcStudentRepository;
import group1.e04.data.Account;


public class Main {

    private static Connection connection = JdbcMysqlConnection.connectDataSource();

    public static void main(String[] args) {
        System.out.println(new JdbcStudentRepository(connection).registerCourse("1", "2"));
    }
}