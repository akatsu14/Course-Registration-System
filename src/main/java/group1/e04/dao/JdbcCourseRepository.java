package group1.e04.dao;

import java.sql.Connection;
import java.util.List;

import group1.e04.data.Course;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcCourseRepository implements DataRepository<Course> {

    private Connection connection;

    @Override
    public boolean save(Course t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Course findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Course> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean update(Course t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
