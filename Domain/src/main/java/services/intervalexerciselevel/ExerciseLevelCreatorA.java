package services.intervalexerciselevel;


import common.Constants;
import entity.Interval;
import entity.Notification;
import enums.Level;
import interfaces.Levelable;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

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

            // if notification is accepted
            if (notification.isAccepted()) {
                LocalTime startTime = interval.getStartTime();
                minutes = (int) startTime.until(notification.getNotificationTime(), ChronoUnit.MINUTES); // returns the minutes ex.: 08:23 -> 23 minutes
                level = getExerciseLevel(minutes);
                levels.add(level);
            }
        } else {
            // get the last notification in the list
            int listSize = notificationList.size();
            Notification checkNotificationA = notificationList.get(listSize - 1);
            Notification checkNotificationB;

            // if the last notification is not accepted don't continue
            if (!checkNotificationA.isAccepted()) {
                return levels;
            } else {
                // check from index of acceptedNotificationA to the next accepted or not notification
                int index = notificationList.indexOf(checkNotificationA); // index = listSize - 1
                checkNotificationB = getAcceptedNotification(index, notificationList);

                // if both are not null, get the difference between the two in minutes.
                if (checkNotificationA != null && checkNotificationB != null) {
                    LocalTime timeA = checkNotificationA.getNotificationTime();
                    LocalTime timeB = checkNotificationB.getNotificationTime();

                    minutes = (int) timeB.until(timeA, ChronoUnit.MINUTES);
                    level = getExerciseLevel(minutes);
                    levels.add(level);
                }
            }
        }
        return levels;
    }

    private Level getExerciseLevel(int minutes) {
        IntPredicate greaterEqualThan0 = i -> i >= 0;
        IntPredicate smallerThan20 = i -> i < 20;
        IntPredicate greaterEqualThan20 = i -> i >= 20;
        IntPredicate smallerThan40 = i -> i < 40;

        if (greaterEqualThan0.and(smallerThan20).test(minutes)) {
            return Level.EASY;
        } else if (greaterEqualThan20.and(smallerThan40).test(minutes)) {
            return Level.MEDIUM;
        } else {
            return Level.HARD;
        }
    }

    /**
     * This method returns accepted notifications. Unless after the last accepted notifications, there are no other
     * accepted notifications. It will return the first notification.
     *
     * @param startingIndex used to loop from this index
     * @param notificationList the list to loop through of type notification
     * @return Notification
     */
    private Notification getAcceptedNotification(int startingIndex, List<Notification> notificationList) {
        Notification notification = null;
        for (int i = startingIndex - 1; i >= 0; i--) {
            notification = notificationList.get(i);

            if (notification.isAccepted()) {
                return notification;
            }
        }
        return notification; // return the last not accepted notification
    }
}
