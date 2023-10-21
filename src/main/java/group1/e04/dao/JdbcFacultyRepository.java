package group1.e04.dao;

import java.sql.Connection;
import java.util.List;

import group1.e04.data.Faculty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcFacultyRepository implements DataRepository<Faculty> {

    private Connection connection;

    @Override
    public boolean save(Faculty faculty) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Faculty findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Faculty> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean update(Faculty faculty) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
