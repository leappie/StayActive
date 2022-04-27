package amcode.domain.services.user;

import amcode.domain.interfaces.Authenticator;
import amcode.domain.entity.User;

public class UserControl {
    private Authenticator authenticator;
    // TODO: How to improve?

    public UserControl(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public User authenticateUser(User user) {
        return this.authenticator.authenticateUser(user);
    }

    public boolean updatePassword(User user) {
        return this.authenticator.updatePassword(user);
    }

    public boolean tryAddUser(User user) {
        return this.authenticator.tryAddUser(user);
    }
}
