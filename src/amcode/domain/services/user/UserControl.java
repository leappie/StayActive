package amcode.domain.services.user;

import amcode.domain.interfaces.Authenticator;
import amcode.domain.model.User;

public class UserControl {
    private Authenticator authenticator;

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
