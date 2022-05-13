package services.alertexercise;

import entity.Alert;
import entity.Exercise;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AlertExerciseCreatorATest {

    @Test
    void getExerciseOnNotificationA() {
        // Arrange
        List<Exercise> exerciseList = createExerciseList();
        List<Level> levelList = new ArrayList<>();
        Alert alert = new Alert(0, "test", null, exerciseList);

        levelList.add(Level.EASY);
        levelList.add(Level.HARD);

        // Act
        Exercise exercise = new AlertExerciseCreatorA().getExerciseOnNotification(alert, levelList);

        // Assert
        Assertions.assertTrue(exercise.getLevel() == Level.EASY || exercise.getLevel() == Level.HARD);
    }

    @Test
    void getExerciseOnNotificationB() {
        List<Exercise> exerciseList = createExerciseList();
        List<Level> levelList = new ArrayList<>();
        Alert alert = new Alert(0, "test", null, exerciseList);

        // Arrange
        levelList = new ArrayList<>();
        levelList.add(Level.HARD);

        // Act
        Exercise exercise = new AlertExerciseCreatorA().getExerciseOnNotification(alert, levelList);

        // Assert
        Assertions.assertTrue(exercise.getLevel() == Level.HARD);
    }

    private List<Exercise> createExerciseList() {
        List<Exercise> exerciseList = new ArrayList<>();

        // 3 easy exercises
        exerciseList.add(new Exercise("Exercise 1", 15, 3, 0, Level.EASY));
        exerciseList.add(new Exercise("Exercise 2", 15, 3, 0, Level.EASY));
        exerciseList.add(new Exercise("Exercise 3", 15, 3, 0, Level.EASY));

        // 3 medium
        exerciseList.add(new Exercise("Exercise 4", 15, 3, 0, Level.MEDIUM));
        exerciseList.add(new Exercise("Exercise 5", 15, 3, 0, Level.MEDIUM));
        exerciseList.add(new Exercise("Exercise 6", 15, 3, 0, Level.MEDIUM));

        // 3 hard
        exerciseList.add(new Exercise("Exercise 7", 15, 3, 0, Level.HARD));
        exerciseList.add(new Exercise("Exercise 8", 15, 3, 0, Level.HARD));
        exerciseList.add(new Exercise("Exercise 9", 15, 3, 0, Level.HARD));

        return exerciseList;
    }
}