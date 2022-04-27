package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.User;

public interface IUserRepository {
    long addUser(User user);
    long updateUser(User user);
    long removeUser(User user);

    User getUser(User user);
    User getUserAlerts(User user);
}
