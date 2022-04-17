package amcode.domain.services;

import amcode.domain.model.User;

public class UserControl {
    public User authenticateUser(User user) {
        // TODO: implement database
        return user;
    }

    public boolean updatePassword(User user) {
        return false;
    }

    public boolean tryAddUser(User user) {
        return false;
    }
}
