package amcode.domain.interfaces;

import amcode.domain.model.User;

public interface Authenticator {
    User authenticateUser(User user);
    boolean updatePassword(User user);
    boolean tryAddUser(User user);
}
