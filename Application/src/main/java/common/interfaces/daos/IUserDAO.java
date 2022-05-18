package common.interfaces.daos;

import entity.User;

import java.util.List;

public interface IUserDAO {

    long insert(User user);
    long update(User user);
    void delete(User user);
    List<User> query(User entity);


}
