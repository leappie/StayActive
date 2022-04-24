package amcode.domain.interfaces;

import amcode.domain.enums.Level;
import amcode.domain.entity.Interval;
import amcode.domain.entity.User;

import java.util.List;

public interface Levelable {
    List<Level> getExerciseDifficulty(Interval interval);
    List<Level> getExerciseDifficulty(Interval interval, User user);
}
