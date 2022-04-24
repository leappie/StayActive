package amcode.application.common.interfaces.repositories;

import amcode.domain.model.Exercise;
import amcode.domain.model.ExerciseHistory;

import java.util.List;

public interface ExerciseHistoryRepository {
    List<ExerciseHistory> getAllExerciseHistories();
    List<ExerciseHistory> getExerciseHistory(Exercise exercise);
    boolean updateExerciseHistory(Exercise exercise, ExerciseHistory exerciseHistory);

}
