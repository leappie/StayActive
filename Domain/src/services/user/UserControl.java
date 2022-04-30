package services.user;


import entity.User;
import interfaces.Authenticator;

/**
 * This classes uses the interface Authenticator to manage users.
 */
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
        return this.authenticator.addNewUser(user);
    }
}
