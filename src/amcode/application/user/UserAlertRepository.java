package amcode.application.user;

import amcode.application.common.interfaces.daos.IUserAlertDao;
import amcode.application.common.interfaces.repositories.IUserAlertRepository;
import amcode.domain.entity.User;

public class UserAlertRepository implements IUserAlertRepository {
    private IUserAlertDao userAlertDao;

    public UserAlertRepository(IUserAlertDao userAlertDao) {
        this.userAlertDao = userAlertDao;
    }

    @Override
    public long addUserAlert(User user) {
        return this.userAlertDao.insertUserAlert(user);
    }

    @Override
    public long updateUserAlert(User user) {
        // NOT IMPLEMENTED
        return -1;
    }

    @Override
    public long removeUserAlert(User user) {
        // NOT IMPLEMENTED
        return -1;
    }

    @Override
    public User getUserAlerts(User user) {
        return this.userAlertDao.getUserAlerts(user);
    }
}
