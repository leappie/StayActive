package amcode.application.common.interfaces.repositories;

import amcode.domain.model.User;

public interface UserRepository {
    User getUser(int id);
    User getUser(User user);
    boolean addUser(User user);
    boolean updateUser(User user);


}
