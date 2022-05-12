package interfaces;

import entity.Interval;

import java.time.LocalTime;

/**
 * This class is used to calculate the notification time.
 */
public interface Notifiable {
    /**
     * The notification time takes an interval. The notifications take place between the start and end time of the
     * interval. Every hour one notification will occur.
     *
     * @param interval used to calculate notification time.
     * @return notification time as LocalTime.
     */
    LocalTime calcNotificationTime(Interval interval);
}
