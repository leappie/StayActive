package alert;


import common.interfaces.DAO;
import common.interfaces.Repository;
import common.interfaces.daos.IAlertDAO;
import common.interfaces.repositories.IAlertRepository;
import entity.Alert;

import java.util.List;

/**
 * Repository to get and sets alert or alert exercises.
 */
public class AlertRepository implements IAlertRepository {
    private IAlertDAO alertDAO;

    public AlertRepository(IAlertDAO alertDAO) {
        this.alertDAO = alertDAO;
    }

    @Override
    public long updateAlert(Alert alert) {
        return this.alertDAO.update(alert);
    }

    @Override
    public void deleteAlert(Alert alert) {
        this.alertDAO.delete(alert);
    }

    @Override
    public List<Alert> getAllAlerts() {
        return this.alertDAO.queryAll();
    }


}
