package services.intervalnotification;


import entity.Interval;
import interfaces.Notifiable;

import java.time.LocalTime;
/**
 * This class uses the interface Notifiable to get the notification time. See Notifiable for more explanation.
 */
public class IntervalNotification {
    private Notifiable notifiable;

    public IntervalNotification(Notifiable notifiable) {
        this.notifiable = notifiable;
    }

    public LocalTime calcNextNotificationTime(Interval interval) {
        return this.notifiable.calcNotificationTime(interval);
    }
}
