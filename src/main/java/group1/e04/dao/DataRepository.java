package group1.e04.dao;

import java.util.List;

public interface DataRepository <T> {
    
    boolean save(T t) throws Exception;
    T findById(String id) throws Exception;
    boolean deleteById(String id) throws Exception;
    List<T> findAll() throws Exception;
    default void sort() {}
}
