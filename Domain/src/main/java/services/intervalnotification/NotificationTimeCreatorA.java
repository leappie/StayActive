package services.intervalnotification;


import common.Constants;
import entity.Interval;
import interfaces.Notifiable;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class NotificationTimeCreatorA implements Notifiable {
    public static final String TAG = "NotificationTimeCreatorB"; // for debugging

    /**
     * This methods returns the notification time.
     *
     * @param interval used to calculate notification time.
     * @return LocalTime
     */
    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime notificationTimeLow; // used to set the lowest time of the interval
        LocalTime notificationTimeHigh; // used to set the highest time of the interval, interval ex. [08:00, 09:00]

        // If all notifications in an interval are triggered -> end. No more notifications.
        if (interval.getNotificationsTriggered() == interval.getTotalNotifications()) {
            return null;
        } else {
            // if only one notification to trigger, then start and end time are equal to the interval
            if (interval.getTotalNotifications() == 1) {
                notificationTimeLow = interval.getSubInterval().getStartTime();
                notificationTimeHigh = interval.getSubInterval().getEndTime();
            } else {
                notificationTimeLow = interval.getSubInterval().getStartTime(); // get the start time of the sub interval
                if (interval.getNotificationsTriggered() == 0) {
                    // If first notification to trigger, then ex.: start time = 08.21 -> 09:00 = end time
                    notificationTimeHigh = notificationTimeLow.truncatedTo(ChronoUnit.HOURS).
                            plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
                } else if (interval.getNotificationsTriggered() == interval.getTotalNotifications() - 1) {
                    // If last notification 16:00 -> 16:30
                    notificationTimeHigh = interval.getSubInterval().getEndTime();
                } else {
                    // every other notification 09:00 -> 10:00
                    notificationTimeHigh = notificationTimeLow.plus(Constants.INTERVAL_LENGTH_MINUTES, ChronoUnit.MINUTES);
                }
            }
        }
        interval.getSubInterval().setStartTime(notificationTimeHigh); // update the next sub interval start time

        // covert times to seconds
        int secondsLow = notificationTimeLow.toSecondOfDay();
        int secondsHigh = notificationTimeHigh.toSecondOfDay();

        // get a random time in seconds between the high and low
        Random random = new Random();
        int randomSeconds = secondsLow + random.nextInt(secondsHigh - secondsLow + 1);
        LocalTime time = LocalTime.ofSecondOfDay(randomSeconds); // convert back to LocalTime

        // update notifications triggered.
        int updateTriggered = interval.getNotificationsTriggered() + 1;
        interval.setNotificationsTriggered(updateTriggered);

        return time; // return notification time
    }
}
