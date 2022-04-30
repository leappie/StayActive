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
//
//    @Test
//    void getExerciseDifficulty() {
//        //Arrange
//        int listSize = 5;
//        int startHour = 9;
//        List<Notification> notificationList = new ArrayList<>();
//        Interval interval = new Interval(null, null); // start and end time are not needed for the calculation of the level
//        Random random = new Random();
//
//        for (int i = startHour; i < listSize; i++) {
//            int check = random.nextInt(2);
//            int minutes = random.nextInt(60);
//            boolean accepted = false;
//
//            if (check == 1) {
//                accepted = true;
//            }
//
//            // add a new random notification
//            notificationList.add(new Notification(LocalTime.of(i, minutes), accepted));
//            // act
//            List<Level> result = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);
//
//            Notification checkA = null;
//            Notification checkB = null;
//            Notification checkC = null;
//            for (int j = notificationList.size() - 1; j >= 0; j--) {
//                Notification notification = notificationList.get(j);
//
//                if (notification.isAccepted()) {
//                    if (checkA == null) {
//                        checkA = notification; // the last accepted notification
//                    } else {
//                        checkB = notification; // the next accepted notification
//                        break;
//                    }
//                }
//                // The first not accepted notification
//                checkC = notification;
//            }
//
//            if (checkA != null && checkB != null) {
//                //Assert
//                LocalTime timeA = checkA.getNotificationTime();
//                LocalTime timeB = checkB.getNotificationTime();
//
//                int diffMinutes = (int) timeB.until(timeA, ChronoUnit.MINUTES);
//                System.out.println(diffMinutes);
//
//                // reset
//                checkA = null;
//                checkB = null;
//            } else if (checkA != null && checkC != null) {
//                // Assert
//                LocalTime timeA = checkA.getNotificationTime();
//                LocalTime timeB = checkC.getNotificationTime();
//
//                int diffMinutes = (int) timeB.until(timeA, ChronoUnit.MINUTES);
//                System.out.println(diffMinutes);
//
//                // reset
//                checkA = null;
//                checkC = null;
//            }
//        }
//    }



}