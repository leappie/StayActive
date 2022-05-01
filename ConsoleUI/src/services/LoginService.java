package services;

import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.User;
import interfaces.Authenticator;
import user.UserRepository;
import user.services.Authenticate;

public class LoginService {

    private Authenticator authenticator;

    public LoginService(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public User authenticateUser(User user) {
        user = this.authenticator.authenticateUser(user);

        if (user != null) {
            CurrentUserService.setLoggedInUser(user);
        }

        return user;
    }

}
