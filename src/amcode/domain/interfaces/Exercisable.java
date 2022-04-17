package amcode.domain.interfaces;

import amcode.domain.enums.Level;
import amcode.domain.model.Alert;

import java.time.LocalTime;
import java.util.List;

public interface Exercisable {
    Level getExerciseDifficulty(LocalTime time);
    List<Level> updateExerciseDifficulty(Alert alert, Level level);
}
