package group1.e04.dao;

import java.util.List;

public interface DataRepository <T> {
    
    boolean save(T t);
    T findById(String id);
    List<T> findAll();
    boolean update(T t);
}
