package amcode.application.alert;

import amcode.application.common.interfaces.daos.IAlertDao;
import amcode.application.common.interfaces.repositories.IAlertRepository;
import amcode.domain.entity.Alert;

import java.util.List;

public class AlertRepository implements IAlertRepository {
    private IAlertDao alertDao;

    public AlertRepository(IAlertDao alertDao) {
        this.alertDao = alertDao;
    }

    @Override
    public long addAlert(Alert alert) {
        // NOT IMPLEMENTED
        return -1;
    }

    @Override
    public long updateAlert(Alert alert) {
        return this.alertDao.updateAlert(alert);
    }

    @Override
    public long removeAlert(Alert alert) {
        return this.alertDao.deleteAlert(alert);
    }

    @Override
    public List<Alert> getAlerts(Alert alert) {
        // NOT IMPLEMENTED
        return null;
    }
}
