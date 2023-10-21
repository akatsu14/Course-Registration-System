package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group1.e04.data.Student;

public class JdbcStudentRepository implements DataRepository<Student> {

    private Connection connection;

    public JdbcStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Student student) {
        if (findById(student.getId()) != null) {
            return false;
        } else {
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(
                    "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?)"
                );
                statement.setString(1, student.getId());
                statement.setString(2, student.getName());
                statement.setString(3, student.getAddress());
                statement.setString(4, student.getPhone());
                statement.setString(5, student.getEmail());
                statement.setString(6, student.get_class());
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

    @Override
    public Student findById(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM student WHERE id=?"
            );
            statement.setString(1, id);
            Student student = new Student();
            boolean flag = false;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flag = true;
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.set_class(resultSet.getString("class"));
                break;
            }
            if (flag) {
                return student;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        PreparedStatement statement;
        List<Student> students = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM student"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("class")
                ));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Student student) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "UPDATE student SET name=?, address=?, phone=?, email=?, class=? WHERE id=?"
            );
            statement.setString(1, student.getName());
            statement.setString(2, student.getAddress());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.get_class());
            statement.setString(6, student.getId());
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
