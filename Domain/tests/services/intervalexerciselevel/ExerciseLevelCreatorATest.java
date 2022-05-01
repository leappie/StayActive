package services.intervalexerciselevel;

import entity.Interval;
import entity.Notification;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;



class ExerciseLevelCreatorATest {

    // Case 1: 1 accepted notification in the list
    @Test
    void getExerciseDifficultyCaseA() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 30), accepted)); // time diff = 30 -> MEDIUM
        Interval interval = new Interval(0, null, null, notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.MEDIUM, level);
    }

    // Case 2: 2 accepted notifications in the list
    @Test
    void getExerciseDifficultyCaseB() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 30), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 15), accepted)); // time diff = 45 -> HARD

        Interval interval = new Interval(0, null, null, notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);

    }

    /*
    Case 3: 1 accepted notifications in the list and 1 not accepted
    SITUATION 1: not accepted, accepted
    SITUATION 2: accepted, not accepted
     */
    @Test
    void getExerciseDifficultyCaseC() {
        // SITUATION 1
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), !accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), accepted)); // time diff < 20 -> EASY

        Interval interval = new Interval(0, null, null, notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.EASY, level);
        // --------------------->

        // SITUATION 2
        //Arrange
        notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 30), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 15), !accepted)); // not accepted so empty list

        interval = new Interval(0, null, null, notificationList);

        // Act
        List<Level> levelList = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);

        // Assert
        Assertions.assertEquals(0, levelList.size());
    }

    /*
    Case 3: 3 accepted notifications in the list
    SITUATION 1: accepted, accepted, accepted
    SITUATION 2: accepted, not accepted, accepted
    SITUATION 3: accepted, accepted, not accepted
    SITUATION 4: not accepted, not accepted, accepted
     */
    @Test
    void getExerciseDifficultyCaseD() {
        // SITUATION 1: accepted, accepted, accepted
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), accepted));
        notificationList.add(new Notification(LocalTime.of(10, 45), accepted)); // time diff last 2 accepted > 40 -> HARD

        Interval interval = new Interval(0, null, null, notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
        // --------------------->

        // SITUATION 2: accepted, not accepted, accepted
        //Arrange
        notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), !accepted));
        notificationList.add(new Notification(LocalTime.of(10, 45), accepted)); // time diff last 2 accepted > 40 -> HARD

        interval = new Interval(0, null, null, notificationList);

        // Act
        level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
        // --------------------->

        // SITUATION 3: accepted, accepted, not accepted
        //Arrange
        notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), accepted));
        notificationList.add(new Notification(LocalTime.of(10, 45), !accepted)); // not accepted so empty list

        interval = new Interval(0, null, null, notificationList);

        // Act
        List<Level> levelList = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);

        // Assert
        Assertions.assertEquals(0, levelList.size());
        // --------------------->

        // SITUATION 4: not accepted, not accepted, accepted
        //Arrange
        notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), !accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), !accepted));
        notificationList.add(new Notification(LocalTime.of(10, 45), accepted)); // time diff last accepted > 40 -> HARD

        interval = new Interval(0, null, null, notificationList);

        // Act
        level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
    }



}