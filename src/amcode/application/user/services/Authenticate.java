package amcode.application.user.services;

import amcode.application.user.UserRepository;
import amcode.domain.interfaces.Authenticator;
import amcode.domain.entity.User;

public class Authenticate implements Authenticator {
    private UserRepository userRepository;

    public Authenticate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(User user) {
        // returns null if user not in db
        return this.userRepository.getUser(user);
    }

    @Override
    public boolean updatePassword(User user) {
        this.userRepository.updateUser(user);

        // check if user can be authenticated with new password
        User checkUser = authenticateUser(user);
        if (checkUser != null) {
            return true;
        }
        return false;
    }


    public boolean tryAddUser(User user) {
        long check = this.userRepository.addUser(user);

        /*
        already a user with same username
         */
        if (check == -1) {
            return false;
        }
        return true;
    }
}