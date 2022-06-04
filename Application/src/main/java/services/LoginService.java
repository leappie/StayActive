package services;

import entity.User;
import interfaces.Authenticator;

public class LoginService {

    private Authenticator authenticator;

    public LoginService(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public User authenticateUser(User user) {
        user = this.authenticator.authenticateUser(user);

        return user;
    }

}
