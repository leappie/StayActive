package useralert;

import common.interfaces.daos.IUserAlertDAO;
import common.interfaces.repositories.IUserAlertRepository;
import entity.User;

import java.util.List;

public class UserAlertRepository implements IUserAlertRepository {
    private IUserAlertDAO userAlertDAO;

    public UserAlertRepository(IUserAlertDAO userAlertDAO) {
        this.userAlertDAO = userAlertDAO;
    }

    @Override
    public long insertUserAlert(User user) {
        return this.userAlertDAO.insert(user);
    }

    @Override
    public User queryUserAlert(User user) {
        User getUser = null;
        List<User> userList = this.userAlertDAO.query(user);

        if (userList.size() > 0) {
            getUser = userList.get(userList.size() - 1);
        }

        return getUser;
    }
}
