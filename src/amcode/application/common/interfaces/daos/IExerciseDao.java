package amcode.application.common.interfaces.daos;

import amcode.domain.entity.Exercise;

import java.util.List;

public interface IExerciseDao {
    long insertExercise(Exercise exercise);
    long updateExercise(Exercise exercise);
    long deleteExercise(Exercise exercise);

    List<Exercise> getAllExercises(Exercise exercise);
}
