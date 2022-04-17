package amcode.domain.interfaces;

import amcode.domain.model.Interval;

import java.time.LocalTime;

public interface Notifiable {
    LocalTime calcNotificationTime(Interval interval);
}
