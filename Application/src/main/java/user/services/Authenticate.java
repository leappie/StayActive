package user.services;

import common.interfaces.repositories.IUserRepository;
import entity.User;
import interfaces.Authenticator;
import user.UserRepository;

/**
 * This class implements the Authenticator and is used to manage users.
 */
public class Authenticate implements Authenticator {
    private IUserRepository userRepository;

    public Authenticate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(User user) {
        return this.userRepository.getUser(user);
    }

    @Override
    public boolean updatePassword(User user) {
        this.userRepository.updateUser(user);

        User checkUser = authenticateUser(user);
        if (checkUser != null) {
            return true;
        }
        return false;
    }


    public boolean addNewUser(User user) {
        long check = this.userRepository.addUser(user);

        if (check == -1) {
            return false;
        }
        return true;
    }
}