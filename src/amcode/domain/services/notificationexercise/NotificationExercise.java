package amcode.domain.services.notificationexercise;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Exercisable;
import amcode.domain.entity.Exercise;

import java.util.List;

public class NotificationExercise {
    private Exercisable exercisable;

    public NotificationExercise(Exercisable exercisable) {
        this.exercisable = exercisable;
    }

    public Exercise getExerciseOnNotification(List<Exercise> exerciseList , List<Level> levelList) {
        return this.exercisable.getExerciseOnNotification(exerciseList, levelList);
    }
}
