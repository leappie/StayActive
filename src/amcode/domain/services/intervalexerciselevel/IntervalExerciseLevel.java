package amcode.domain.services.intervalexerciselevel;

import amcode.domain.entity.Interval;
import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;

import java.util.List;

public class IntervalExerciseLevel {
    private Levelable levelable;

    public IntervalExerciseLevel(Levelable levelable) {
        this.levelable = levelable;
    }


    public List<Level> getExerciseDifficulty(Interval interval) {
        return this.levelable.getExerciseDifficulty(interval);
    }
}
