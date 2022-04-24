package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Exercise;
import amcode.domain.entity.ExerciseHistory;

import java.util.List;

public interface ExerciseHistoryRepository {
    List<ExerciseHistory> getAllExerciseHistories();
    List<ExerciseHistory> getExerciseHistory(Exercise exercise);
    boolean updateExerciseHistory(Exercise exercise, ExerciseHistory exerciseHistory);

}
