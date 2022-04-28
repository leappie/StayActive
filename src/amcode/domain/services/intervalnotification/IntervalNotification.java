package amcode.domain.services.intervalnotification;

import amcode.domain.entity.Interval;
import amcode.domain.interfaces.Notifiable;

import java.time.LocalTime;

public class IntervalNotification {
    private Notifiable notifiable;

    public IntervalNotification(Notifiable notifiable) {
        this.notifiable = notifiable;
    }

    public LocalTime calcNextNotificationTime(Interval interval) {
        return this.notifiable.calcNotificationTime(interval);
    }
}
