package services;

import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.User;
import interfaces.Authenticator;
import user.UserRepository;
import user.services.Authenticate;

public class LoginService {

    private DAO<User> userDAO;
    private Authenticator authenticator;

    public LoginService(DAO<User> userDAO, Authenticator authenticator) {
        this.userDAO = userDAO;
        this.authenticator = authenticator;
    }

    public LoginService(DAO<User> userDAO) {
        this.userDAO = userDAO;
        UserRepository userRepository = new UserRepository(this.userDAO);
        this.authenticator = new Authenticate(userRepository);
    }

    public User authenticateUser(User user) {
        if (this.authenticator != null) {
            user = this.authenticator.authenticateUser(user);
        } else {
            user = null;
        }

        if (user != null) {
            CurrentUserService.setLoggedInUser(user);
        }

        return user;
    }

}
