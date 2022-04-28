package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Exercise;

import java.util.List;

public interface IExerciseRepository {
    void addExercise(Exercise exercise);
    void updateExercise(Exercise exercise);
    void removeExercise(Exercise exercise);

    List<Exercise> getAllExercises(Exercise exercise);

}
