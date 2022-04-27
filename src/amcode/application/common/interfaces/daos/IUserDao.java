package amcode.application.common.interfaces.daos;

import amcode.domain.entity.User;

public interface IUserDao {
    long insertUser(User user);
    long updateUser(User user);
    long deleteUser(User user);

    User getUser(User user);
    User getUserAlerts(User user);
}
