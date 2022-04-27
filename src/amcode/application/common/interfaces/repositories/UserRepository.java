package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.User;

public interface UserRepository {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(User user);


}
