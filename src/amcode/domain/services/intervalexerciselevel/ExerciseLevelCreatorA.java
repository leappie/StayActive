package amcode.domain.services.intervalexerciselevel;

import amcode.domain.entity.Interval;
import amcode.domain.entity.Notification;
import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExerciseLevelCreatorA implements Levelable {
    public static final String TAG = "ExerciseLevelCreatorA";

    @Override
    public List<Level> getExerciseDifficulty(Interval interval) {
        List<Notification> notificationList = interval.getNotificationList();
        List<Level> levels = new ArrayList<>();
        Level level;
        int minutes;

        // if first notification
        if (notificationList.size() == 1) {
            Notification notification = notificationList.get(notificationList.size() - 1);

            if (notification.isAccepted()) {
                LocalTime now = LocalTime.now();
                LocalTime notTime = notification.getNotificationTime();

//                if (notTime.compareTo(now) < 0) {
//                    minutes = (int) ChronoUnit.MINUTES.between(now, now.truncatedTo(ChronoUnit.HOURS).
//                            plusMinutes(Constants.INTERVAL_LENGTH_MINUTES));
//                } else {
//                    minutes = notification.getNotificationTime().getMinute();
//                }

                minutes = notification.getNotificationTime().getMinute();

                level = getExerciseLevel(minutes);
                levels.add(level);

//                System.out.println(TAG + ": minutes ->" + minutes);
            }
        } else {
            // get de last two accepted notifications;
            int listSize = notificationList.size();
            Notification acceptedNotificationA;
            Notification acceptedNotificationB;

            acceptedNotificationA = getAcceptedNotification(listSize, notificationList);

            // check from index of acceptedNotificationA
            int index = notificationList.indexOf(acceptedNotificationA);
            acceptedNotificationB = getAcceptedNotification(index, notificationList);

//            System.out.println(TAG + ": acceptedNotificationA ->" + acceptedNotificationA);
//            System.out.println(TAG + ": acceptedNotificationB ->" + acceptedNotificationB);

            if (acceptedNotificationA != null && acceptedNotificationB != null) {
                LocalTime timeA = acceptedNotificationA.getNotificationTime();
                LocalTime timeB = acceptedNotificationB.getNotificationTime();

                minutes = (int) timeB.until(timeA, ChronoUnit.MINUTES);
                level = getExerciseLevel(minutes);
                levels.add(level);
//                System.out.println(TAG + ": minutes ->" + minutes);
            }
        }
        return levels;
    }

    private Level getExerciseLevel(int minutes) {
        if (minutes >= 0 && minutes < 20) {
            return Level.EASY;
        } else if (minutes >= 20 && minutes < 40) {
            return Level.MEDIUM;
        } else {
            return Level.HARD;
        }
    }

    private Notification getAcceptedNotification(int listSize, List<Notification> notificationList) {
        Notification notification;
        for (int i = listSize - 1; i >= 0; i--) {
            notification = notificationList.get(i);

            if (notification.isAccepted()) {
                return notification;
            }
        }
        return null;
    }
}
