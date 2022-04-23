package amcode.domain.services.user;

import amcode.domain.interfaces.Authenticator;
import amcode.domain.model.User;

public class UserControl {
    public User authenticateUser(Authenticator authenticator, User user) {
        return authenticator.authenticateUser(user);
    }

    public boolean updatePassword(Authenticator authenticator, User user) {
        return authenticator.updatePassword(user);
    }

    public boolean tryAddUser(Authenticator authenticator, User user) {
        return authenticator.tryAddUser(user);
    }
}
