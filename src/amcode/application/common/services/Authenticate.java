package amcode.application.common.services;

import amcode.domain.model.User;

import java.util.concurrent.ThreadLocalRandom;

public class Authenticate {

    public User authenticateUser(User user) {
        // TODO: implement database
        // NOTE: NO DEPENDENCY ON INFRASTRUCTURE!
        int randomNum = ThreadLocalRandom.current().nextInt(1, 11);
        if (randomNum < 5) {
            user = null;
        }
        return user;
    }

    public boolean updatePassword(User user) {
        return true;
    }

    public boolean tryAddUser(User user) {
        // TODO: implement database
        // NOTE: IF USERNAME IS TAKEN RETURN FALSE:
        return true;
    }
}