package amcode.domain.services.alertexercise;

import amcode.domain.entity.Alert;
import amcode.domain.enums.Level;
import amcode.domain.interfaces.Exercisable;
import amcode.domain.entity.Exercise;

import java.util.List;

public class AlertExercise {
    private Exercisable exercisable;

    public AlertExercise(Exercisable exercisable) {
        this.exercisable = exercisable;
    }

    public Exercise getExerciseOnNotification(Alert alert, List<Level> levelList) {
        return this.exercisable.getExerciseOnNotification(alert, levelList);
    }
}
