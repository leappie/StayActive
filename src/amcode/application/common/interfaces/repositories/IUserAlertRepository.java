package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.User;

public interface IUserAlertRepository {
    long addUserAlert(User user);
    long updateUserAlert(User user);
    long removeUserAlert(User user);

    User getUserAlerts(User user);
}
