package services.intervalnotification;

import common.Constants;
import entity.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Same test as A except startTime = now
 */
class NotificationTimeCreatorBTest {
    @Test
    void testCalcNotificationTime() {
        // Arrange
        int hourEndTime = 23;
        int minutesEndTime = 59;

        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);


        /*
        Get sub interval example:
        main interval is: (08:23-17:30)
        sub intervals are: (08:23-09:00), (09:00-10:00), ..., (17:00-17:30)
         */
        LocalTime subStartTime = LocalTime.now();
        LocalTime subEndTime = LocalTime.of(hourEndTime, minutesEndTime);
        long subStartTimeSeconds = subStartTime.toSecondOfDay();
        long subEndTimeSeconds = subEndTime.toSecondOfDay();

        while (interval.getTotalNotifications() != interval.getNotificationsTriggered()) {
            // Act
            LocalTime result = new NotificationTimeCreatorB().calcNotificationTime(interval); // the result to be compared
            int resultSeconds = result.toSecondOfDay();

            /*
            If one notification check assertTrue else calc subs
             */
            if (interval.getTotalNotifications() > 1) {
                subStartTimeSeconds = subStartTime.toSecondOfDay();
                if (interval.getNotificationsTriggered() == 1) {
                    // sub interval example: (08:23-09:00)
                    subEndTime = subStartTime.truncatedTo(ChronoUnit.HOURS).plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
                    subEndTimeSeconds = subEndTime.toSecondOfDay();
                } else if (interval.getNotificationsTriggered() == interval.getTotalNotifications()) {
                    // sub interval example: (17:00-17:30)
                    long seconds = endTime.toSecondOfDay();
                    subEndTime = LocalTime.ofSecondOfDay(seconds);
                    subEndTimeSeconds = subEndTime.toSecondOfDay();
                } else {
                    // sub interval example: (09:00-10:00)
                    subEndTime = subStartTime.plus(Constants.INTERVAL_LENGTH_MINUTES, ChronoUnit.MINUTES);
                    subEndTimeSeconds = subEndTime.toSecondOfDay();
                }
            }

            System.out.println(subStartTime);
            System.out.println(subEndTime);
            System.out.println();
            subStartTime = LocalTime.ofSecondOfDay(subEndTimeSeconds);

            // Assert
            Assertions.assertTrue(resultSeconds >= subStartTimeSeconds && resultSeconds <= subEndTimeSeconds);
        }
    }
}