package amcode.application.common.interfaces.repositories;

import amcode.domain.model.Exercise;

import java.util.List;

public interface ExerciseRepository {
    List<Exercise> getAllExercises();
    Exercise getExercise(int id);
    Exercise getExercise(Exercise exercise);
    boolean updateExercise(Exercise exercise);
}
