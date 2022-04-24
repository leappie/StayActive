package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Exercise;

public interface ExerciseRepository {
    void addExercise(Exercise exercise);
    void updateExercise(Exercise exercise);
    void removeExercise(Exercise exercise);

}
