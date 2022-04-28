package amcode.application.alert;

import amcode.application.common.interfaces.daos.IAlertExerciseDao;
import amcode.application.common.interfaces.repositories.IAlertExerciseRepository;
import amcode.domain.entity.Alert;

public class AlertExerciseRepository implements IAlertExerciseRepository {
    private IAlertExerciseDao alertExerciseDao;

    public AlertExerciseRepository(IAlertExerciseDao alertExerciseDao) {
        this.alertExerciseDao = alertExerciseDao;
    }

    @Override
    public long addAlertExercise(Alert alert) {
        return this.alertExerciseDao.insertAlertExercise(alert);
    }

    @Override
    public long updateAlertExercise(Alert alert) {
        return this.alertExerciseDao.updateAlertExercise(alert);
    }

    @Override
    public long removeAlertExercise(Alert alert) {
        return this.alertExerciseDao.deleteAlertExercise(alert);
    }

    @Override
    public Alert getAlertExercises(Alert alert) {
        return this.alertExerciseDao.getAlertExercises(alert);
    }
}
