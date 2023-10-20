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
        if (this.findById(student.getId()) != null) {
            return false;
        } else {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(
                    "INSERT INTO course_system_management.student VALUES (?, ?, ?, ?, ?, ?)"  
                );
                preparedStatement.setString(1, student.getId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getAddress());
                preparedStatement.setString(4, student.getPhone());
                preparedStatement.setString(5, student.getEmail());
                preparedStatement.setString(6, student.get_class());
                preparedStatement.executeUpdate();
                connection.commit();
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
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
                "SELECT * FROM course_system_management.student WHERE id = ?"
            );
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Student student = new Student();
            boolean flag = false;
            while (resultSet.next()) {
                flag = true;
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.set_class(resultSet.getString("class"));
            }
            if (flag) {
                return student;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "DELETE FROM course_system_management.student WHERE id = ?"
            );
            statement.setString(1, id);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM course_system_management.student"
            );
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                students.add(new Student(
                    result.getString("id"), 
                    result.getString("name"), 
                    result.getString("address"), 
                    result.getString("phone"), 
                    result.getString("email"), 
                    result.getString("class")
                ));
            }
            return students;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
