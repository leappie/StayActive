package services.alertexercise;


import entity.Alert;
import entity.Exercise;
import enums.Level;
import interfaces.Exercisable;

import java.util.List;

/**
 * This class uses the interface Exercisable to get the exercise on notification. See Exercisable for more explanation.
 */
public class AlertExercise {
    private Exercisable exercisable;

    public AlertExercise(Exercisable exercisable) {
        this.exercisable = exercisable;
    }

    public Exercise getExerciseOnNotification(Alert alert, List<Level> levelList) {
        return this.exercisable.getExerciseOnNotification(alert, levelList);
    }
}
