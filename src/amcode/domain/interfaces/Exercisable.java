package amcode.domain.interfaces;

import amcode.domain.enums.Level;
import amcode.domain.model.Alert;
import amcode.domain.model.Interval;

import java.util.List;

public interface Exercisable {
    Level getExerciseDifficulty(Interval interval);
    List<Level> updateExerciseDifficulty(Alert alert, Level level);
}
