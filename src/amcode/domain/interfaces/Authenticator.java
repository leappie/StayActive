package amcode.domain.interfaces;

import amcode.domain.entity.User;

public interface Authenticator {
    User authenticateUser(User user);
    boolean updatePassword(User user);
    boolean tryAddUser(User user);
}
