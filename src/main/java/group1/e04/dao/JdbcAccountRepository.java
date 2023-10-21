package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group1.e04.data.Account;
import group1.e04.data.Account.Role;


public class JdbcAccountRepository {

    private Connection connection;

    public JdbcAccountRepository(Connection connection) {
        this.connection = connection;
    }

    public Account findById(String username) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM account WHERE username=?"  
            );
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            Account account = new Account();
            boolean flag = false;
            while (resultSet.next()) {
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setRole(Role.valueOf(resultSet.getString("role")));
                flag = true;
                break;
            }
            if (flag) {
                return account;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Account account, String userId) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "INSERT INTO account VALUES(?, ?, ?)"
            );
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getRole().name());
            statement.executeUpdate();
            if (account.getRole().compareTo(Role.STUDENT) == 0) {
                PreparedStatement statement2 = connection.prepareStatement(
                    "UPDATE student SET account_id=? WHERE id=?"
                );
                statement2.setString(1, account.getUsername());
                statement2.setString(2, userId);
                statement2.executeUpdate();
            } else if (account.getRole().compareTo(Role.FACULTY) == 0) {
                PreparedStatement statement2 = connection.prepareStatement(
                    "UPDATE faculty SET account_id=? WHERE id=?"
                );
                statement2.setString(1, account.getUsername());
                statement2.setString(2, userId);
                statement2.executeUpdate();
            }
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String username, String password) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "UPDATE account SET password=? WHERE username=?"
            );
            statement.setString(1, password);
            statement.setString(2, username);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }
}
