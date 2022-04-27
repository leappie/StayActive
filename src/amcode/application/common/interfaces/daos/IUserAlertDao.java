package amcode.application.common.interfaces.daos;

import amcode.application.common.dtos.UserAlertsDTO;

import java.util.List;

public interface IUserAlertDao {
    long insertUser(UserAlertsDTO userAlertsDTO);
    long updateUser(UserAlertsDTO userAlertsDTO);
    long deleteUser(UserAlertsDTO userAlertsDTO);

    List<UserAlertsDTO> getUserAlerts(UserAlertsDTO userAlertsDTO);
}
