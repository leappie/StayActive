package services.intervalexerciselevel;


import entity.Interval;
import enums.Level;
import interfaces.Levelable;

import java.util.List;

/**
 * This class uses the interface Levelable to get the exercise level. See Levelable for more explanation.
 */
public class IntervalExerciseLevel {
    private Levelable levelable;

    public IntervalExerciseLevel(Levelable levelable) {
        this.levelable = levelable;
    }


    public List<Level> getExerciseDifficulty(Interval interval) {
        return this.levelable.getExerciseDifficulty(interval);
    }
}
