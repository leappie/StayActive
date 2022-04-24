package amcode.application.common.services;

import amcode.domain.interfaces.Authenticator;
import amcode.domain.entity.User;

public class Authenticate implements Authenticator {

    public User authenticateUser(User user) {
        // TODO: implement database
        // NOTE: NO DEPENDENCY ON INFRASTRUCTURE!

        //HARD CODED:
        if (user.getUsername().equals("a") && user.getPassword().equals("m")) {
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