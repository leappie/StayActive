package amcode.domain.services;

import amcode.domain.interfaces.Notifiable;
import amcode.domain.model.Interval;

import java.time.LocalTime;

public class NotificationTimeCreatorA implements Notifiable {
    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        return null;
    }
}
