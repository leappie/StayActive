package amcode.application.common.interfaces.daos;

public interface Dao<T> {
    long insertUser(T model);
    long updateUser(T model);
    long deleteUser(T model);

    T getUser(T model);
}
