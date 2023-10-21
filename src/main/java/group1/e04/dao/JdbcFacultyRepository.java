package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group1.e04.data.Faculty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcFacultyRepository implements DataRepository<Faculty> {

    private Connection connection;

    public List<String> findAllCourseAreTeaching(String facultyId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM course WHERE faculty_id=?");
            statement.setString(1, facultyId);
            ResultSet resultSet = statement.executeQuery();
            List<String> courseIds = new ArrayList<>();
            while (resultSet.next()) {
                courseIds.add(resultSet.getString("id"));
            }
            return courseIds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Faculty findByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM faculty WHERE account_id=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Faculty(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("department"),
                        findAllCourseAreTeaching(resultSet.getString("id")));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Faculty faculty) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO faculty(id, name, address, phone, email, department) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, faculty.getId());
            statement.setString(2, faculty.getName());
            statement.setString(3, faculty.getAddress());
            statement.setString(4, faculty.getPhone());
            statement.setString(5, faculty.getEmail());
            statement.setString(6, faculty.getDepartment());
            int rowEffected = statement.executeUpdate();
            if (rowEffected == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
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
    public Faculty findById(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM faculty WHERE id=?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Faculty(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("department"),
                        findAllCourseAreTeaching(resultSet.getString("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Faculty faculty) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE faculty SET name=?, address=?, phone=?, email=?, department=? WHERE id=?");
            statement.setString(1, faculty.getName());
            statement.setString(2, faculty.getAddress());
            statement.setString(3, faculty.getPhone());
            statement.setString(4, faculty.getEmail());
            statement.setString(5, faculty.getDepartment());
            statement.setString(6, faculty.getId());
            int rowEffected = statement.executeUpdate();
            if (rowEffected == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
