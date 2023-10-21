package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group1.e04.data.Course;

public class JdbcCourseRepository implements DataRepository<Course> {

    private Connection connection;

    public JdbcCourseRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Course course) {
        if (this.findById(course.getId()) != null) {
            return false;
        } else {
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(
                    "INSERT INTO course VALUES(?, ?, ?, ?)"
                );
                statement.setString(1, course.getId());
                statement.setString(2, course.getName());
                statement.setString(3, course.getCredit());
                statement.setString(4, course.getFacultyId());
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
    public Course findById(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM course WHERE id=?"  
            );
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            boolean flag = false;
            Course course = new Course();
            while (resultSet.next()) {
                flag = true;
                course.setId(resultSet.getString("id"));
                course.setName(resultSet.getString("name"));
                course.setCredit(resultSet.getString("credit"));
                course.setFacultyId(resultSet.getString("faculty_id"));
                break;
            }
            if (flag) {
                return course;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "SELECT * FROM course"
            );
            ResultSet resultSet = statement.executeQuery();
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                courses.add(new Course(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("credit"),
                    resultSet.getString("faculty_id")
                ));
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Course course) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                "UPDATE course SET name=?, credit=?, faculty_id=? WHERE id=?"
            );
            statement.setString(1, course.getName());
            statement.setString(2, course.getCredit());
            statement.setString(3, course.getFacultyId());
            statement.setString(4, course.getId());
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }      
            e.printStackTrace();
        }
        return false;
    }
    
}
