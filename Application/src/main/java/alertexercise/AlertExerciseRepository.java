package alertexercise;

import common.interfaces.daos.IAlertExerciseDAO;
import common.interfaces.repositories.IAlertExerciseRepository;
import entity.Alert;

import java.util.List;

public class AlertExerciseRepository implements IAlertExerciseRepository {
    private IAlertExerciseDAO alertExerciseDAO;

    public AlertExerciseRepository(IAlertExerciseDAO alertExerciseDAO) {
        this.alertExerciseDAO = alertExerciseDAO;
    }

    @Override
    public long insertAlertExercise(Alert alert) {
        return this.alertExerciseDAO.insert(alert);
    }

    @Override
    public long updateAlertExercise(Alert alert) {
        return this.alertExerciseDAO.update(alert);
    }

    @Override
    public void deleteAlertExercise(Alert alert) {
        this.alertExerciseDAO.delete(alert);
    }

    @Override
    public Alert getAlertExercise(Alert alert) {
        Alert getAlert = null;
        List<Alert> alertList = this.alertExerciseDAO.query(alert);

        if (alertList.size() > 0) {
            getAlert = alertList.get(alertList.size() - 1);
        }

        return getAlert;
    }


}
