package services;

import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.User;
import user.UserRepository;
import user.services.Authenticate;

public class LoginService {

    private DAO<User> userDAO;

    public LoginService(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    public User authenticateUser(User user) {
        UserRepository userRepository = new UserRepository(this.userDAO);
        user = new Authenticate(userRepository).authenticateUser(user);

        if (user != null) {
            CurrentUserService.setLoggedInUser(user);
        }

        return user;
    }

}
