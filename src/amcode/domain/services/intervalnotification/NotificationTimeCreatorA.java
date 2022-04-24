package amcode.domain.services.intervalnotification;

import amcode.domain.common.Constants;
import amcode.domain.interfaces.Notifiable;
import amcode.domain.entity.Interval;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class NotificationTimeCreatorA implements Notifiable {
    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime notificationTimeLow;
        LocalTime notificationTimeHigh;

        notificationTimeLow = interval.getStartTime().plus(
                (long) Constants.INTERVAL_LENGTH_MINUTES * interval.getNotificationsTriggered(), ChronoUnit.MINUTES);

        // if all notifications triggered -> end
        if (interval.getNotificationsTriggered() == interval.getTotalNotifications()) {
            return null;
            // if it is the last notification
        } else if (interval.getNotificationsTriggered() == interval.getTotalNotifications() - 1) {
            notificationTimeHigh = interval.getEndTime();
        } else {
            notificationTimeHigh = notificationTimeLow.plus(Constants.INTERVAL_LENGTH_MINUTES, ChronoUnit.MINUTES);
        }

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
