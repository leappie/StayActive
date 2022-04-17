package amcode.domain.services;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Exercisable;
import amcode.domain.model.Alert;

import java.time.LocalTime;
import java.util.List;

public class ExerciseLevelCreatorA implements Exercisable {
    @Override
    public Level getExerciseDifficulty(LocalTime time) {
        return null;
    }

    @Override
    public List<Level> updateExerciseDifficulty(Alert alert, Level level) {
        return null;
    }
}
