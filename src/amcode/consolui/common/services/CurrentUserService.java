package amcode.consolui.common.services;

import amcode.domain.entity.User;

/**
 * Deze class geeft de ingelogde user terug.
 * In overleg met Rene, gebruik gemaakt van static hier.
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
