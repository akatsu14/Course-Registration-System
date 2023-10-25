package group1.e04;

import java.sql.Connection;

import group1.e04.config.JdbcMysqlConnection;
import group1.e04.model.Student;
import group1.e04.view.LoginView;

public class Main {

    private static Connection connection = JdbcMysqlConnection.connectDataSource();

    public static void main(String[] args) {
        LoginView login = new LoginView();
        Student student = new Student();
        login.onLogin();
    }
}