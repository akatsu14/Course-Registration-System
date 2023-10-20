package group1.e04.dao;

import java.util.List;

public interface DataRepository <T> {
    
    boolean save(T t);
    T findById(String id);
    boolean deleteById(String id);
    List<T> findAll();
    default void sort() {}
}
