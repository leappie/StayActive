package common.interfaces;

import java.util.List;

/**
 * This interface sets the base methods that every DAO must have.
 *
 * @param <T>
 */
public interface DAO<T>{
    long insert(T entity);
    long update(T entity);
    long delete(T entity);

    List<T> query(T entity);

}
