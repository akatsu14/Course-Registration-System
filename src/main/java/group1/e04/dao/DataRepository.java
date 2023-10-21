package group1.e04.dao;

public interface DataRepository <T> {
    
    boolean save(T t);
    T findById(String id);
    boolean update(T t);
    default T findByUsername(String username) {return null;}
}
