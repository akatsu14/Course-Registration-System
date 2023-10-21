package group1.e04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import group1.e04.data.Student;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcStudentRepository implements DataRepository<Student> {

    private Connection connection;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Student> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean update(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
