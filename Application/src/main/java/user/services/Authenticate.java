package user.services;

import entity.User;
import interfaces.Authenticator;
import user.UserRepository;

import java.util.List;

/**
 * This class implements the Authenticator and is used to manage users.
 */
public class Authenticate implements Authenticator {
    private UserRepository userRepository;

    public Authenticate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(User user) {
        List<User> userList = this.userRepository.get(user);
        User checkUser = null;

        // if user found get it
        if (userList.size() > 0) {
            checkUser = userList.get(userList.size() - 1);
        }
        return checkUser;
    }

    @Override
    public boolean updatePassword(User user) {
        this.userRepository.update(user);

        // TODO:
        // check if user can be authenticated with new password
        User checkUser = authenticateUser(user);
        if (checkUser != null) {
            return true;
        }
        return false;
    }


    public boolean addNewUser(User user) {
        long check = this.userRepository.add(user);

        // TODO:
        /*
        already a user with same username
         */
        if (check == -1) {
            return false;
        }
        return true;
    }
}