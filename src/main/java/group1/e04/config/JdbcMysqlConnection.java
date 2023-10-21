package group1.e04.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcMysqlConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/course_system_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection connectDataSource() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
