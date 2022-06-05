package services;

import common.interfaces.daos.IAlertExerciseDAO;
import entity.Alert;
import entity.Exercise;
import entity.Interval;
import entity.Notification;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class NotificationServiceTest {

    @Test
    void getExerciseOnNotification() {
        // Arrange
        Alert alertMock = Mockito.mock(Alert.class);
        Interval intervalMock = Mockito.mock(Interval.class);
        Notification notificationMock = Mockito.mock(Notification.class);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime notificationTime = LocalTime.of(8, 30);
        IAlertExerciseDAO alertExerciseDAOMock = Mockito.mock(IAlertExerciseDAO.class);

        Mockito.when(alertMock.getInterval()).thenReturn(intervalMock);
        Mockito.when(alertMock.getExerciseList()).thenReturn(createExerciseList());
        Mockito.when(intervalMock.getStartTime()).thenReturn(startTime);
        Mockito.when(intervalMock.getNotificationList()).thenReturn(new ArrayList<>(List.of(notificationMock)));
        Mockito.when(notificationMock.isAccepted()).thenReturn(true);
        Mockito.when(notificationMock.getNotificationTime()).thenReturn(notificationTime);

        Mockito.when(alertExerciseDAOMock.update(alertMock)).thenReturn(0L);
        Mockito.when(alertExerciseDAOMock.query(alertMock)).thenReturn(new ArrayList<>(List.of(alertMock)));

        // Act
        Exercise exercise = new NotificationService(alertExerciseDAOMock).getExerciseOnNotification(alertMock);

        // Assert
        Assertions.assertSame(exercise.getLevel(), Level.MEDIUM); // Difference between startTime and NotificationTime is 30 min
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