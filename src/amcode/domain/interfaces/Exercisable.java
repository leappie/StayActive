package amcode.domain.interfaces;

import amcode.domain.enums.Level;
import amcode.domain.model.Interval;
import amcode.domain.model.User;

import java.util.List;

public interface Exercisable {
    Level getExerciseDifficulty(Interval interval);
    List<Level> updateExerciseDifficulty(User user, Level level);
}
