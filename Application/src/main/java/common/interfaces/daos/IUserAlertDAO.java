package common.interfaces.daos;

import entity.User;

import java.util.List;

public interface IUserAlertDAO {

    long insert(User user);
    List<User> query(User entity);

}
