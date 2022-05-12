package alert;


import common.interfaces.DAO;
import common.interfaces.Repository;
import entity.Alert;

import java.util.List;

/**
 * Repository to get and sets alert or alert exercises.
 */
public class AlertRepository implements Repository<Alert> {
    private DAO<Alert> alertDAO;

    public AlertRepository(DAO<Alert> alertDAO) {
        this.alertDAO = alertDAO;
    }

    @Override
    public long add(Alert entity) {
        return this.alertDAO.insert(entity);
    }

    @Override
    public long update(Alert entity) {
        return this.alertDAO.update(entity);
    }

    @Override
    public long remove(Alert entity) {
        return this.alertDAO.delete(entity);
    }

    @Override
    public List<Alert> get(Alert entity) {
        return this.alertDAO.query(entity);
    }
}
