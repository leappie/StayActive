package services.intervalexerciselevel;

import entity.Interval;
import entity.Notification;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseLevelCreatorATest {

    @Test
    void getExerciseDifficulty() {
        //Arrange
        int listSize = 5;
        int startHour = 9;
        List<Notification> notificationList = createNotificationList(listSize, startHour);
        Interval interval = new Interval(0,null, null, notificationList); // start and end time are not needed for the calculation of the level

        //Act
        List<Level> result = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);

        Notification checkA = null;
        Notification checkB = null;
        Notification checkC = null;
        for (int i = notificationList.size() - 1; i >= 0; i--) {
            Notification notification = notificationList.get(i);

            if (notification.isAccepted()) {
                if (checkA == null) {
                    checkA = notification; // the last accepted notification
                } else {
                    checkB = notification; // the next accepted notification
                    break;
                }
            }
            // The first not accepted notification
            checkC = notification;
        }



    }

    private List<Notification> createNotificationList(int size, int startHour) {
        List<Notification> notificationList = new ArrayList<>();
        Random random = new Random();

        for (int i = startHour; i < size; i++) {
            int check = random.nextInt(2);
            int minutes = random.nextInt(60);
            boolean accepted = false;

            if (check == 1) {
                accepted = true;
            }
            notificationList.add(new Notification(LocalTime.of(i, minutes), accepted));
        }
        return notificationList;
    }
}