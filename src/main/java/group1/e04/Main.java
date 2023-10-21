package group1.e04;

import java.sql.Connection;

import group1.e04.config.JdbcMysqlConnection;
import group1.e04.dao.JdbcAccountRepository;
import group1.e04.data.Account;


public class Main {

    private static Connection connection = JdbcMysqlConnection.connectDataSource();

    public static void main(String[] args) {
        JdbcAccountRepository accountRepo = new JdbcAccountRepository(connection);
        accountRepo.save(new Account("B21DCAT113", "123", Account.Role.STUDENT), "B21DCAT113");
        System.out.println(accountRepo.findById("B21DCAT113"));
    }
}