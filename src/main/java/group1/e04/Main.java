package group1.e04;

import java.sql.Connection;

import group1.e04.config.JdbcConnection;
import group1.e04.dao.JdbcStudentRepository;
import group1.e04.data.Student;

public class Main {

    private static Connection connection = JdbcConnection.connectDataSource();

    public static void main(String[] args) {
        JdbcStudentRepository repo = new JdbcStudentRepository(connection);
        System.out.println(repo.findAll().toString());
        System.out.println(repo.findById("B21DCAT113").toString());
        repo.deleteById("B21DCAT013");
        repo.save(new Student("B21DCAT013", "Nguyen Nhat Minh", "", "", "", "E21CQCN04"));
        System.out.println(repo.findAll().toString());
    }
}