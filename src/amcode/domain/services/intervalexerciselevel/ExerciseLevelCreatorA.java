package amcode.domain.services.intervalexerciselevel;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;
import amcode.domain.model.Interval;
import amcode.domain.model.Notification;
import amcode.domain.model.User;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExerciseLevelCreatorA implements Levelable {
    @Override
    public List<Level> getExerciseDifficulty(Interval interval) {
        List<Notification> notificationList = interval.getNotificationList();
        List<Level> levels = new ArrayList<>();
        Level level;
        int minutes;

        if (notificationList.size() == 1 ) {
            Notification notification = notificationList.get(notificationList.size() - 1);

            if (notification.isAccepted()) {
                minutes = notification.getNotificationTime().getMinute();
                level = getExerciseLevel(minutes);
                levels.add(level);
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

            if (acceptedNotificationA != null && acceptedNotificationB != null) {
                LocalTime timeA = acceptedNotificationA.getNotificationTime();
                LocalTime timeB = acceptedNotificationB.getNotificationTime();

                minutes = (int) timeA.until(timeB, ChronoUnit.MINUTES);
                level  = getExerciseLevel(minutes);
                levels.add(level);
            }
        }
        return levels;
    }

    @Override
    public List<Level> getExerciseDifficulty(Interval interval, User user) {
        Level userLevel = user.getLevel();
        List<Level> exerciseLevels = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);
        Level level = exerciseLevels.get(exerciseLevels.size() - 1);

        switch (userLevel) {
            // include more easy exercises
            case EASY:
                if (level == Level.MEDIUM) {
                    exerciseLevels.add(Level.EASY);
                } else if (level == Level.HARD) {
                    exerciseLevels.add(Level.MEDIUM);
                }
                break;
            case MEDIUM:
                // include more difficult exercises
                if (level == Level.EASY) {
                    exerciseLevels.add(Level.EASY);
                    exerciseLevels.add(Level.MEDIUM);
                } else if (level == Level.MEDIUM) {
                    exerciseLevels.add(Level.MEDIUM);
                    exerciseLevels.add(Level.HARD);
                } else {
                    exerciseLevels.add(Level.HARD);
                }
                break;
            default:
                break;
        }
        return null;
    }

    private Level getExerciseLevel(int minutes) {
        if (minutes >=0 && minutes < 20) {
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
