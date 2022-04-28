package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Alert;

public interface IAlertExerciseRepository {
    long addAlertExercise(Alert alert);
    long updateAlertExercise(Alert alert);
    long removeAlertExercise(Alert alert);

    Alert getAlertExercises(Alert alert);
}
