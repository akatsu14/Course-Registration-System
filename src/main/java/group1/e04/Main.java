package group1.e04;

import group1.e04.view.LoginView;

public class Main {

    // private static Connection connection =
    // JdbcMysqlConnection.connectDataSource();

    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.onLogin();
    }
}