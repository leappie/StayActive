package interfaces;



import entity.Alert;
import entity.Exercise;
import enums.Level;

import java.util.List;

/**
 * This interface is used by the classes that will decide which exercise must be done on a notification.
 */
public interface Exercisable {
    /**
     * Every alert holds all the exercises and their weights. An exercise weight decides how many times that exercise
     * can occur. The levelList is used to get an exercise in certain level range.
     *
     * @param alert used to get the exercises and their weights
     * @param levelList used to decide exercise difficulty
     * @return exercise
     */
    Exercise getExerciseOnNotification(Alert alert, List<Level> levelList);
}
