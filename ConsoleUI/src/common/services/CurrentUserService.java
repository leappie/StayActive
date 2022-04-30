package common.services;

import entity.User;

/**
 * Deze class geeft de ingelogde user terug.
 * In overleg met Rene, gebruik gemaakt van static hier.
 *
 * Een andere mogelijkheid is misschien de user op te slaan in een config file OF the user meegeven als een inputField.
 */
public class CurrentUserService {
    private static User _user;

    private CurrentUserService(){
    }

    public static boolean setLoggedInUser(User user) {
        if (user != null) {
            _user = user;
            return true;
        } else {
            return false;
        }
    }

    public static User getLoggedInUser() {
        return _user;
    }

}
