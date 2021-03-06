package services.intervalnotification;


import entity.Interval;

import java.time.LocalTime;

//TODO: Question -> Extend NotificationTimeCreatorB and use super OR Interface?
public class NotificationTimeCreatorB extends NotificationTimeCreatorA {
    public static final String TAG = "NotificationTimeCreatorB"; // for debugging

    /**
     * This method is an extension on notificationTimeCreatorA. The notification time will be calculated from how late it
     * is now, instead of the start time of the interval.
     *
     * @param interval used to calculate notification time.
     * @return LocalTime
     */
    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime startTime = interval.getSubInterval().getStartTime();
        LocalTime now = LocalTime.now();

        /*
         * if time now > start time, start notifications from now
         * Example if start time is 08:00 but now is 09:00, show only notification from 09:00
         */
        if (startTime.compareTo(now) < 0) {
            interval.getSubInterval().setStartTime(now);

            /* Change total notifications because now is later than start time interval.
             * So in this means less notifications.
             */
            int total = interval.getSubInterval().getTotalNotifications();
            interval.setTotalNotifications(total);
        }

        return super.calcNotificationTime(interval);
    }

}
