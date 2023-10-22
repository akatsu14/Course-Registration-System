package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group1.e04.data.Course;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcCourseRepository implements DataRepository<Course> {

    private Connection connection;

    @Override
    public boolean save(Course course) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO course(id, name, credit, max_student) VALUES(?, ?, ?, ?)");
            statement.setString(1, course.getId());
            statement.setString(2, course.getName());
            statement.setInt(3, course.getCredit());
            statement.setInt(4, course.getMaxStudent());
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

    private String findFacultyNameById(String facultyId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT name FROM faculty WHERE id=?");
            statement.setString(1, facultyId);
            ResultSet resulSet = statement.executeQuery();
            if (resulSet.next()) {
                return resulSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int countStudentInCourse(String courseId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(student_id) AS count_student FROM register WHERE course_id=?");
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("count_student");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Course findById(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM course WHERE id=?");
            statement.setString(1, id);
            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                Course course = new Course();
                course.setId(resultset.getString("id"));
                course.setName(resultset.getString("name"));
                course.setCredit(resultset.getInt("credit"));
                course.setMaxStudent(resultset.getInt("max_student"));
                course.setFacultyName(findFacultyNameById(
                        resultset.getString("faculty_id")));
                course.setCurrentStudent(
                        countStudentInCourse(resultset.getString("id")));
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Course course) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE course SET name=?, credit=?, max_student=? WHERE id=?"
            );
            statement.setString(1, course.getName());
            statement.setInt(2, course.getCredit());
            statement.setInt(3, course.getMaxStudent());
            statement.setString(4, course.getId()); 
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

    public boolean registerCourseForStudent(String studentId, String courseId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO register VALUES(?, ?)");
            statement.setString(1, studentId);
            statement.setString(2, courseId);
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
}
