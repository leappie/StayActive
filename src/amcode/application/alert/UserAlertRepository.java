package amcode.application.alert;

import amcode.application.common.dtos.UserAlertsDTO;
import amcode.application.common.interfaces.daos.IUserAlertDao;
import amcode.application.common.interfaces.repositories.IUserAlertRepository;

import java.util.List;

public class UserAlertRepository implements IUserAlertRepository {
    private IUserAlertDao alertDao;

    public UserAlertRepository(IUserAlertDao alertDao) {
        this.alertDao = alertDao;
    }

    @Override
    public long addUserAlert(UserAlertsDTO userAlertsDTO) {
        return 0;
    }

    @Override
    public long updateUserAlert(UserAlertsDTO userAlertsDTO) {
        return 0;
    }

    @Override
    public long removeUserAlert(UserAlertsDTO userAlertsDTO) {
        return 0;
    }

    @Override
    public List<UserAlertsDTO> getUserAlerts(UserAlertsDTO userAlertsDTO) {
        return null;
    }
}
