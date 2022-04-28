package amcode.domain.services.intervalnotification;

import amcode.domain.interfaces.Notifiable;
import amcode.domain.entity.Interval;

import java.time.LocalTime;

public class NotificationTimeCreatorB implements Notifiable {
    public static final String TAG = "NotificationTimeCreatorB"; // for debugging

    @Override
    public LocalTime calcNotificationTime(Interval interval) {
        LocalTime startTime = interval.getIntermediateInterval().getStartTime();
        LocalTime endTime = interval.getIntermediateInterval().getEndTime();
        LocalTime now = parseLocalTime(LocalTime.now().toString());

//        System.out.println(TAG + " -> " + interval);
//        System.out.println(TAG + " -> " + chosenInterval);

        // if now > startTime, start notifications from now
        // Example if startTime is 08:00 but now is 09:00, show only
        // notification from 09:00
        if (startTime.compareTo(now) < 0) {
            interval.getIntermediateInterval().setStartTime(now);

            // reset total notifications because now is later than start interval
            int total = interval.getIntermediateInterval().getTotalNotifications();
            interval.setTotalNotifications(total);
            System.out.println(total);
        }

        NotificationTimeCreatorA notificationTimeCreatorA = new NotificationTimeCreatorA();
        return notificationTimeCreatorA.calcNotificationTime(interval);
    }

    private LocalTime parseLocalTime(String value) {
        String time = value.substring(0, 5);

        return LocalTime.parse(time);
    }
}
