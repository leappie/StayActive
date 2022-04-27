package amcode.domain.interfaces;

import amcode.domain.entity.Alert;
import amcode.domain.enums.Level;
import amcode.domain.entity.Exercise;

import java.util.List;

public interface Exercisable {
    Exercise getExerciseOnNotification(Alert alert, List<Level> levelList);
}
