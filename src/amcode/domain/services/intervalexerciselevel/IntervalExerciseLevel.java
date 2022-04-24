package amcode.domain.services.intervalexerciselevel;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;
import amcode.domain.model.Alert;

import java.time.LocalTime;
import java.util.List;

public class IntervalExerciseLevel {
    private Levelable levelable;

    public IntervalExerciseLevel(Levelable levelable) {
        this.levelable = levelable;
    }

    public Level getExerciseDifficulty(LocalTime time) {
        return null;
    }

    public List<Level> updateExerciseDifficulty(Alert alert, Level level) {
        return null;
    }
}
