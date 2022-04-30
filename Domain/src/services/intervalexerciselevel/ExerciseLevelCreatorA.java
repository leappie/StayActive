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
                minutes = notification.getNotificationTime().getMinute(); // returns the minutes ex.: 08:23 -> 23 minutes
                level = getExerciseLevel(minutes);
                levels.add(level);
            }
        } else {
            // get de last two 'accepted' notifications;
            int listSize = notificationList.size();
            Notification acceptedNotificationA;
            Notification acceptedOrNotNotificationB;

            acceptedNotificationA = getAcceptedNotification(listSize, notificationList);

            // check from index of acceptedNotificationA
            int index = notificationList.indexOf(acceptedNotificationA);
            acceptedOrNotNotificationB = getAcceptedNotification(index, notificationList);

            // if both are not null, get the difference between the two in minutes.
            if (acceptedNotificationA != null && acceptedOrNotNotificationB != null) {
                LocalTime timeA = acceptedNotificationA.getNotificationTime();
                LocalTime timeB = acceptedOrNotNotificationB.getNotificationTime();

                minutes = (int) timeB.until(timeA, ChronoUnit.MINUTES);
                level = getExerciseLevel(minutes);
                levels.add(level);
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
