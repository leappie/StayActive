package amcode.domain.services.intervalnotification;

import amcode.domain.interfaces.Notifiable;
import amcode.domain.model.Interval;
import amcode.domain.model.Notification;

import java.time.LocalTime;

public class IntervalNotification {
    private Notifiable notifiable;

    public IntervalNotification(Notifiable notifiable) {
        this.notifiable = notifiable;
    }

    public LocalTime calcNextNotificationTime(Interval interval) {
        LocalTime notificationTime = this.notifiable.calcNotificationTime(interval);
        interval.getNotificationList().add(new Notification(notificationTime));

        return notificationTime;
    }
}
