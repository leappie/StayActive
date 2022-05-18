package common.interfaces.repositories;

import entity.Alert;

import java.util.List;

public interface IAlertExerciseRepository {

    long insertAlertExercise(Alert alert);
    long updateAlertExercise(Alert alert);
    void deleteAlertExercise(Alert alert);
    Alert getAlertExercise(Alert alert);
}
