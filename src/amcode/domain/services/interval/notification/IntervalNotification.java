package amcode.domain.services.interval.notification;

import amcode.domain.interfaces.Notifiable;
import amcode.domain.model.Interval;
import amcode.domain.model.Notification;

import java.time.LocalTime;

public class IntervalNotification {
    public LocalTime calcNextNotificationTime(Notifiable notifiable, Interval interval) {
        LocalTime notificationTime = notifiable.calcNotificationTime(interval);
        interval.getNotificationList().add(new Notification(notificationTime));

        return notificationTime;
    }
}
