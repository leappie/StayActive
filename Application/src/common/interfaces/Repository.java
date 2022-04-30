package common.interfaces;

import java.util.List;

/**
 * This interface sets the base functions that every Repository must have.
 * The methods depend on the DAO.
 */
public interface Repository<T> {
    long add(T entity);
    long update(T entity);
    long remove(T entity);

    List<T> get(T entity);

}
