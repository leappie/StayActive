package amcode.application.common.interfaces.repositories;

import amcode.application.common.dtos.UserAlertsDTO;

import java.util.List;

public interface IUserAlertRepository {
    long addUserAlert(UserAlertsDTO userAlertsDTO);
    long updateUserAlert(UserAlertsDTO userAlertsDTO);
    long removeUserAlert(UserAlertsDTO userAlertsDTO);

    List<UserAlertsDTO> getUserAlerts(UserAlertsDTO userAlertsDTO);


}
