package services;

import common.interfaces.daos.IUserAlertDAO;
import common.interfaces.repositories.IUserAlertRepository;
import entity.User;
import useralert.UserAlertRepository;

public class MainService {

    private IUserAlertDAO userAlertDAO;

    public MainService(IUserAlertDAO userAlertDAO) {
        this.userAlertDAO = userAlertDAO;
    }

    public User getUserNAlerts(User loggedInUser) {
        IUserAlertRepository userAlertRepository = new UserAlertRepository(this.userAlertDAO);
        User user = userAlertRepository.queryUserAlert(loggedInUser);

        return user;
    }
}
