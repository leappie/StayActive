package services;

import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.User;
import user.UserRepository;

import java.util.List;

public class MainService {

    private DAO<User> userAlertDAO;

    public MainService(DAO<User> userAlertDAO) {
        this.userAlertDAO = userAlertDAO;
    }

    public User getUserNAlerts(User loggedInUser) {
        UserRepository userRepository = new UserRepository(this.userAlertDAO);
        List<User> userList = userRepository.get(loggedInUser);
        User user = userList.get(userList.size() - 1);

        CurrentUserService.setLoggedInUser(user); // update loggedInUser

        return user;
    }
}
