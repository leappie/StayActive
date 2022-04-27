package amcode.domain.interfaces;

import amcode.domain.entity.Interval;
import amcode.domain.enums.Level;

import java.util.List;

public interface Levelable {
    List<Level> getExerciseDifficulty(Interval interval);
}
