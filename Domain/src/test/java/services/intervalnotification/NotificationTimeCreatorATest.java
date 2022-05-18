package services.intervalnotification;

import common.Constants;
import entity.Interval;
import entity.Notification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * The notification time returned depends on the start and end time.
 * 1. If start time is like 08:23 and end time like 09:00
 * There will be only one notification between these two times.
 *
 * 2. If start time is like 08:23 and end time like 10:00
 * There will be 2 notifications:
 *  - Notification 1 between 08:23 and 09:00
 *  - Notification 2 between 09:00 and 10:00
 *
 * 3. If start time is like 08:23 and end time like 10:53
 * There will be 3 notifications:
 *  - Notification 1 between 08:23 and 09:00
 *  - Notification 2 between 09:00 and 10:00
 *  - Notification 3 between 10:00 and 10:53
 */
public class NotificationTimeCreatorATest {

    @Test
    void testCalcNotificationTime() {
        // Arrange
        int hourStartTime = 9; // Note date time exception when you try values out of range of [00:00, 23:59]
        int minutesStartTime = 59;
        int hourEndTime = 17;
        int minutesEndTime = 59;

        LocalTime startTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);


        /*
        Get sub interval example:
        main interval is: (08:23-17:30)
        sub intervals are: (08:23-09:00), (09:00-10:00), ..., (17:00-17:30)
         */
        LocalTime subStartTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime subEndTime = LocalTime.of(hourEndTime, minutesEndTime);
        long subStartTimeSeconds = subStartTime.toSecondOfDay();
        long subEndTimeSeconds = subEndTime.toSecondOfDay();

        while (interval.getTotalNotifications() != interval.getNotificationsTriggered()) {
            // Act
            LocalTime result = new NotificationTimeCreatorA().calcNotificationTime(interval); // the result to be compared
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
            System.out.println(LocalTime.ofSecondOfDay(subStartTimeSeconds));
            System.out.println(result);
            System.out.println(LocalTime.ofSecondOfDay(subEndTimeSeconds));
            System.out.println("-------------------------");

            subStartTime = LocalTime.ofSecondOfDay(subEndTimeSeconds);

            // Assert
            Assertions.assertTrue(resultSeconds >= subStartTimeSeconds && resultSeconds <= subEndTimeSeconds);
        }
    }

    /*
    startTime > EndTime
     */
    @Test
    void constraintTest() {
        // Arrange
        int hourStartTime = 17;
        int minutesStartTime = 59;
        int hourEndTime = 9;
        int minutesEndTime = 59;

        LocalTime startTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);

        // Act
        LocalTime result = new NotificationTimeCreatorA().calcNotificationTime(interval);

        //Assert
        Assertions.assertEquals(null, result);
    }

    /*
    start time = 09:00, end time = 09:15
     */
    @Test
    void specificSituationTestA() {
        // Arrange
        int hourStartTime = 9;
        int minutesStartTime = 00;
        int hourEndTime = 9;
        int minutesEndTime = 15;

        LocalTime startTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);

        // Act
        LocalTime result = new NotificationTimeCreatorA().calcNotificationTime(interval);

        //Assert
        Assertions.assertTrue(
                result.getHour() >= hourStartTime
                        && result.getHour() <= hourEndTime
                        && result.getMinute() >= minutesStartTime
                        && result.getMinute() <= minutesEndTime);

    }




}