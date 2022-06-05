import common.interfaces.daos.IExerciseDAO;
import entity.Alert;
import entity.Exercise;
import entity.Interval;
import enums.Level;
import exercise.ExerciseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.alertexercise.AlertExerciseCreatorA;
import services.intervalnotification.NotificationTimeCreatorB;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class DAOMockTest {
    @Test
    void getExerciseOnNotification() {
        // Arrange
        IExerciseDAO exerciseDAOMock = Mockito.mock(IExerciseDAO.class);
        ExerciseRepository exerciseRepository = new ExerciseRepository(exerciseDAOMock);
        Alert alertMock = Mockito.mock(Alert.class);
        List<Level> levelList = new ArrayList<>();
        levelList.add(Level.HARD);

        Mockito.when(exerciseDAOMock.queryAll()).thenReturn(createExerciseList());
        List<Exercise> exerciseList = exerciseRepository.getAllExercises();
        Mockito.when(alertMock.getExerciseList()).thenReturn(exerciseList);

        // Act
        Exercise exercise = new AlertExerciseCreatorA().getExerciseOnNotification(alertMock, levelList);

        // Assert
        Assertions.assertSame(exercise.getLevel(), Level.HARD);
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
