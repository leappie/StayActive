package common.interfaces.repositories;

import entity.User;

import java.util.List;

public interface IUserAlertRepository {

    long insertUserAlert(User user);
    User queryUserAlert(User user);

}
