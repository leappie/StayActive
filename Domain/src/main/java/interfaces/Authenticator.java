package interfaces;

import entity.User;

/**
 * This interface is used by the class(es) that will handle the authentication.
 * If I want to switch and use an API, I can make a new class
 * which will implement this interface.
 */
public interface Authenticator {
    User authenticateUser(User user);
    boolean updatePassword(User user);
    boolean addNewUser(User user);
}
