package amcode.domain.interfaces;

import amcode.domain.enums.Level;
import amcode.domain.entity.Exercise;

import java.util.List;

public interface Exercisable {
    Exercise getExerciseOnNotification(List<Exercise> exerciseList, List<Level> levelList);
}
