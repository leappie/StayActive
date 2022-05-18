package common.interfaces.repositories;

import entity.User;

public interface IUserRepository {

    long addUser(User user);
    long updateUser(User user);
    void deleteUser(User user);
    User getUser(User entity);


}
