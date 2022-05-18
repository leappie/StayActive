package services;

import common.interfaces.DAO;
import common.interfaces.daos.IUserAlertDAO;
import common.interfaces.repositories.IUserAlertRepository;
import common.services.CurrentUserService;
import entity.User;
import user.UserRepository;
import useralert.UserAlertRepository;

import java.util.List;

public class MainService {

    private IUserAlertDAO userAlertDAO;

    public MainService(IUserAlertDAO userAlertDAO) {
        this.userAlertDAO = userAlertDAO;
    }

    public User getUserNAlerts(User loggedInUser) {
        IUserAlertRepository userAlertRepository = new UserAlertRepository(this.userAlertDAO);
        User user = userAlertRepository.queryUserAlert(loggedInUser);

        CurrentUserService.setLoggedInUser(user); // update loggedInUser

        return user;
    }
}
