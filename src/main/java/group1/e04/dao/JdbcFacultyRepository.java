package group1.e04.dao;

import java.sql.Connection;

import group1.e04.data.Faculty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcFacultyRepository implements DataRepository<Faculty> {

    private Connection connection;

    @Override
    public Faculty findByUsername(String username) {
        
    }

    @Override
    public boolean save(Faculty faculty) {

    }

    @Override
    public Faculty findById(String id) {

    }

    @Override
    public boolean update(Faculty faculty) {

    }

}
