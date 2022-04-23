package amcode.domain.services.interval.notification;

import amcode.domain.interfaces.Notifiable;
import amcode.domain.model.Interval;

import java.time.LocalTime;

public class NotificationTimeCreatorB implements Notifiable {
    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime startTime = interval.getStartTime();
        LocalTime now = LocalTime.now();

        // if now > startTime, start notifications from now
        // Example if startTime is 08:00 but now is 09:00, show only
        // notification from 09:00
        if (startTime.compareTo(now) < 0) {
            interval.setStartTime(now);
        }

        NotificationTimeCreatorA notificationTimeCreatorA = new NotificationTimeCreatorA();
        return notificationTimeCreatorA.calcNotificationTime(interval);
    }
}
