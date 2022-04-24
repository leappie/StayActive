package amcode.domain.services.interval.exerciselevel;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;
import amcode.domain.model.Alert;

import java.time.LocalTime;
import java.util.List;

public class IntervalExerciseLevel {
    public Level getExerciseDifficulty(Levelable levelable, LocalTime time) {
        return null;
    }

    public List<Level> updateExerciseDifficulty(Levelable levelable, Alert alert, Level level) {
        return null;
    }
}
