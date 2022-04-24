package amcode.application.common.services;

import amcode.domain.interfaces.Authenticator;
import amcode.domain.model.User;

public class Authenticate implements Authenticator {

    public User authenticateUser(User user) {
        // TODO: implement database
        // NOTE: NO DEPENDENCY ON INFRASTRUCTURE!

        //HARD CODED:
        if (user.getUsername() == "a" && user.getPassword() == "m") {
            return user;
        }
        return null;
    }

    @Override
    public boolean updatePassword(User user) {
        return false;
    }


    public boolean tryAddUser(User user) {
        // TODO: implement database
        // NOTE: IF USERNAME IS TAKEN RETURN FALSE:

        return true;
    }
}