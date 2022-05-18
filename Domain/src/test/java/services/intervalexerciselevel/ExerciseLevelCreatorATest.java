package services.intervalexerciselevel;

import entity.Interval;
import entity.Notification;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


class ExerciseLevelCreatorATest {

    // Case 1: 1 accepted notification in the list
    @Test
    void getExerciseDifficultyCaseA() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 30), accepted)); // time diff = 30 -> MEDIUM
        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

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

        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);

    }

    /*
    Case 3: 1 accepted notifications in the list and 1 not accepted
    SITUATION 1: not accepted, accepted
     */
    @Test
    void getExerciseDifficultyCaseC_1() {
        // SITUATION 1
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), !accepted));
        notificationList.add(new Notification(LocalTime.of(9, 3), accepted)); // time diff < 20 -> EASY

        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.EASY, level);
    }

    /*
    Case 3: 1 accepted notifications in the list and 1 not accepted
    SITUATION 2: accepted, not accepted
    */
    @Test
    void getExerciseDifficultyCaseC_2() {
        // SITUATION 2
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = new ArrayList<>();
        notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 30), accepted));
        notificationList.add(new Notification(LocalTime.of(9, 15), !accepted)); // not accepted so empty list

        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        List<Level> levelList = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);

        // Assert
        Assertions.assertEquals(0, levelList.size());
    }

    /*
    Case 4: 3 accepted notifications in the list
    SITUATION 1: accepted, accepted, accepted
     */
    @Test
    void getExerciseDifficultyCaseD_1() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = createNotificationListSize3(accepted, accepted, accepted);
        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
    }

    /*
    Case 4: 3 accepted notifications in the list
    SITUATION 2: accepted, not accepted, accepted
     */
    @Test
    void getExerciseDifficultyCaseD_2() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = createNotificationListSize3(accepted, !accepted, accepted);
        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
    }

    /*
    Case 4: 3 accepted notifications in the list
    SITUATION 3: accepted, accepted, not accepted
     */
    @Test
    void getExerciseDifficultyCaseD_3() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = createNotificationListSize3(accepted, accepted, !accepted);
        Interval interval = new Interval(0, LocalTime.of(8,0), LocalTime.of(17,0), notificationList);

        // Act
        List<Level> levelList = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);

        // Assert
        Assertions.assertEquals(0, levelList.size());
    }

    /*
    Case 4: 3 accepted notifications in the list
    SITUATION 3: not accepted, not accepted, accepted
     */
    @Test
    void getExerciseDifficultyCaseD_4() {
        //Arrange
        boolean accepted = true;
        List<Notification> notificationList = createNotificationListSize3(!accepted, !accepted, accepted);
        Interval interval = new Interval(0, LocalTime.of(8, 0), LocalTime.of(17, 0), notificationList);

        // Act
        Level level = new ExerciseLevelCreatorA().getExerciseDifficulty(interval).get(0);

        // Assert
        Assertions.assertEquals(Level.HARD, level);
    }


    private List<Notification> createNotificationListSize3(boolean accept1, boolean accept2, boolean accept3) {
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(LocalTime.of(8, 45), accept1));
        notificationList.add(new Notification(LocalTime.of(9, 3), accept2));
        notificationList.add(new Notification(LocalTime.of(10, 45), accept3));

        return notificationList;
    }

}