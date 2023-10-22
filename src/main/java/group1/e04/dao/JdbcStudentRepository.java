package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group1.e04.data.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcStudentRepository implements DataRepository<Student> {

    private Connection connection;

    public List<String> findAllCoursesAreLearning(String studentId) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT course_id FROM register WHERE student_id=?");
            statement.setString(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            List<String> courseIds = new ArrayList<>();
            while (resultSet.next()) {
                courseIds.add(resultSet.getString("course_id"));
            }
            return courseIds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findByUsername(String username) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM student WHERE account_id=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            Student student = new Student();
            if (resultSet.next()) {
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.set_class(resultSet.getString("class"));
                student.setCourseIds(findAllCoursesAreLearning(student.getId()));
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
    public boolean save(Student student) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO student(id, name, address, phone, email, class) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.get_class());
            int rowEffected = statement.executeUpdate();
            if (rowEffected > 0) {
                connection.commit();
                return true;
            }
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

    @Override
    public Student findById(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM student WHERE id=?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Student student = new Student();
            if (resultSet.next()) {
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.set_class(resultSet.getString("class"));
                student.setCourseIds(findAllCoursesAreLearning(student.getId()));
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
    public boolean update(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE student SET name=?, address=?, phone=?, email=?, class=? WHERE id=?");
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
