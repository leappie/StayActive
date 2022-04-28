package amcode.application.common.interfaces.daos;

import amcode.domain.entity.User;

public interface IUserAlertDao {
    long insertUserAlert(User user);
    long updateUseAlert(User user);
    long deleteUserAlert(User user);

    User getUserAlerts(User user);
}
