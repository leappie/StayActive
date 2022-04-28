package amcode.application.common.interfaces.daos;

import amcode.domain.entity.Alert;

public interface IAlertExerciseDao {
    long insertAlertExercise(Alert alert);
    long updateAlertExercise(Alert alert);
    long deleteAlertExercise(Alert alert);

    Alert getAlertExercises(Alert alert);
}
