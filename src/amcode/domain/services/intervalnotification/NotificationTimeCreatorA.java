package amcode.domain.services.intervalnotification;

import amcode.domain.common.Constants;
import amcode.domain.interfaces.Notifiable;
import amcode.domain.entity.Interval;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class NotificationTimeCreatorA implements Notifiable {
    public static final String TAG = "NotificationTimeCreatorB"; // for debugging

    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime notificationTimeLow;
        LocalTime notificationTimeHigh;

//        System.out.println(interval);
        // if all notifications trigger ed -> end
        if (interval.getNotificationsTriggered() == interval.getTotalNotifications()) {
            return null;
        } else {
            notificationTimeLow = interval.getIntermediateInterval().getStartTime();
            if (interval.getNotificationsTriggered() == 0) {
                // First notification ex. 08.21 -> 09:00
                notificationTimeHigh = notificationTimeLow.truncatedTo(ChronoUnit.HOURS).
                        plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
            } else if (interval.getNotificationsTriggered() == interval.getTotalNotifications() - 1) {
                // Last notification 16:00 -> 16:30
                notificationTimeHigh = interval.getIntermediateInterval().getEndTime();
            } else {
                // every other notification
                notificationTimeHigh = notificationTimeLow.plus(Constants.INTERVAL_LENGTH_MINUTES, ChronoUnit.MINUTES);

            }
        }

        interval.getIntermediateInterval().setStartTime(notificationTimeHigh);
//        System.out.println(TAG + ": -> notificationTimeLow " + notificationTimeLow);
//        System.out.println(TAG + ": -> notificationTimeHigh " + notificationTimeHigh);

        // calc notification time
        int secondsLow = notificationTimeLow.toSecondOfDay();
        int secondsHigh = notificationTimeHigh.toSecondOfDay();

        Random random = new Random();
        int randomSeconds = secondsLow + random.nextInt(secondsHigh - secondsLow + 1);
        LocalTime time = LocalTime.ofSecondOfDay(randomSeconds);

        // update fields
        int updateTriggered = interval.getNotificationsTriggered() + 1;
        interval.setNotificationsTriggered(updateTriggered);

        return time;
    }
}
