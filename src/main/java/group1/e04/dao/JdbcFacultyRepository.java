package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group1.e04.data.Faculty;

public class JdbcFacultyRepository implements DataRepository<Faculty> {
    private Connection connection;

    public JdbcFacultyRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Faculty faculty) {
        if (this.findById(faculty.getId()) != null) {
            return false;
        } else {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO course_system_management.faculty VALUES (?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, faculty.getId());
                preparedStatement.setString(2, faculty.getName());
                preparedStatement.setString(3, faculty.getAddress());
                preparedStatement.setString(4, faculty.getPhone());
                preparedStatement.setString(5, faculty.getEmail());
                preparedStatement.setString(6, faculty.getDepartment());
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
    public Faculty findById(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM course_system_management.faculty WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Faculty faculty = new Faculty();
            boolean flag = false;
            while (resultSet.next()) {
                flag = true;
                faculty.setId(resultSet.getString("id"));
                faculty.setName(resultSet.getString("name"));
                faculty.setAddress(resultSet.getString("address"));
                faculty.setPhone(resultSet.getString("phone"));
                faculty.setEmail(resultSet.getString("email"));
                faculty.setDepartment(resultSet.getString("class"));
            }
            if (flag) {
                return faculty;
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
                    "DELETE FROM course_system_management.faculty WHERE id = ?");
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
    public List<Faculty> findAll() {
        List<Faculty> faculties = new ArrayList<>();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM course_system_management.faculty");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                faculties.add(new Faculty(
                        result.getString("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getString("phone"),
                        result.getString("email"),
                        result.getString("department")));
            }
            return faculties;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
