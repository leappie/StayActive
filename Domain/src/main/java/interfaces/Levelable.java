package interfaces;


import entity.Interval;
import enums.Level;

import java.util.List;

/**
 * This interface is used by classes that will calculate the difficulty of an exercise.
 */
public interface Levelable {
    /**
     * The interval holds a list of past notifications. The exercise difficulty depends on the time between the last two
     * accepted notifications.
     *
     * @param interval
     * @return list of levels
     */
    List<Level> getExerciseDifficulty(Interval interval);
}
