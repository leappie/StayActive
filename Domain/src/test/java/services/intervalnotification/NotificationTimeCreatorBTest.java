package services.intervalnotification;

import common.Constants;
import entity.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

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

            subStartTime = LocalTime.ofSecondOfDay(subEndTimeSeconds);

            // Assert
            Assertions.assertTrue(resultSeconds >= subStartTimeSeconds && resultSeconds <= subEndTimeSeconds);
        }
    }

    /**
     * This test checks specific Notification moments depending on the Interval and the amount of notifications already
     * triggered. To do this I needed mock objects.
     *
     * @throws Exception
     */
    @Test
    void testMock() {
        // Arrange
        Interval interval = Mockito.mock(Interval.class);
        NotificationTimeCreatorB notificationTimeCreatorB = Mockito.mock(NotificationTimeCreatorB.class);

        // DO NOT Change
        final int START_HOUR = 8;
        final int START_MINUTE = 30;
        final int END_HOUR = 17;
        final int END_MINUTE = 30;
        final int TOTAL_NOTIFICATIONS = 8;
        final LocalTime START_TIME = LocalTime.of(START_HOUR,START_MINUTE);
        final LocalTime END_TIME = LocalTime.of(END_HOUR,END_MINUTE);

        // Play with this to get different notification time
        int notificationsTriggered = 7; // must be smaller than 8, else calcNotificationTime will return null because all notifications are already triggered
        LocalTime subStartTime = getStartTimeSubInterval(notificationsTriggered, START_TIME);

        Mockito.when(interval.getTotalNotifications()).thenReturn(TOTAL_NOTIFICATIONS);
        Mockito.when(interval.getNotificationsTriggered()).thenReturn(notificationsTriggered);
        Mockito.when(interval.getStartTime()).thenReturn(START_TIME);
        Mockito.when(interval.getEndTime()).thenReturn(END_TIME);
        Mockito.when(interval.getSubInterval()).thenReturn(interval);
        Mockito.when(interval.getSubInterval().getStartTime()).thenReturn(subStartTime);
        Mockito.when(notificationTimeCreatorB.calcNotificationTime(interval)).thenCallRealMethod();

        // Act
        LocalTime resultTime = notificationTimeCreatorB.calcNotificationTime(interval);
        System.out.println(resultTime);
        long resultTimeSeconds = resultTime.toSecondOfDay();
        long startTimeSeconds = subStartTime.toSecondOfDay();
        long endTimeSubSeconds = getEndTimeSubInterval(notificationsTriggered, START_TIME, END_TIME).toSecondOfDay();

        // Assert
        Assertions.assertTrue(resultTimeSeconds >= startTimeSeconds && resultTimeSeconds <= endTimeSubSeconds);
    }

    /**
     * This method returns the subInterval startTime based on the amount of notifications already triggered.
     *
     * - notifications triggered is 0 => return start time main interval: 08:30
     *
     * - notifications triggered is 1 => return start time + x minutes s.t. start time is rounded above to the next hour,
     * e.g.: if start time = 08:30 -> return 09:00
     *
     * - notifications triggered is > 1 => return start time + x minutes s.t. start time is rounded above to the next hour
     * + 60 minutes * (notificationsTriggered - 1), e.g.: if start time = 08:30 -> return 09:00 + 01:00 * (notificationsTriggered - 1)
     *
     *
     * @param notificationsTriggered number of notifications already triggered
     * @param startTime start time as LocalTime
     * @return LocalTime
     */
    private LocalTime getStartTimeSubInterval(int notificationsTriggered, LocalTime startTime) {
        LocalTime startTimeReturn;
        if (notificationsTriggered == 0) {
            startTimeReturn = startTime;
        } else if (notificationsTriggered == 1){
            startTimeReturn = startTime.truncatedTo(ChronoUnit.HOURS).
                    plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
        } else {
            startTimeReturn = startTime.truncatedTo(ChronoUnit.HOURS).
                    plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
            startTimeReturn = startTimeReturn.plus((long) Constants.INTERVAL_LENGTH_MINUTES *
                    (notificationsTriggered - 1), ChronoUnit.MINUTES);
        }

        return startTimeReturn;
    }

    /**
     * This method returns the expected end time of the sub interval.
     * Normally this will also depend on the total number of Notifications possible to trigger.
     * In this mock test I have fixed this number to 8 based on the Interval length.
     *
     * - notifications triggered is 0 => return start time + x minutes s.t. end time is rounded above to the next hour,
     * e.g.: start time 08:30 -> end time 09:00
     *
     * - notifications triggered is 1 => return start time + x minutes s.t. start time us rounded above to the next hour
     *  + 60 minutes * notificationsTriggered, e.g.: start time = 08:30 -> end time = 09:00 + 01:00 * notificationsTriggered
     *
     * - notifications triggered is > 1 => return end time main interval: 17:30
     *
     *
     * @param notificationsTriggered number of notifications already triggered
     * @param startTime start time as LocalTime
     * @param endTime end time as LocalTime
     * @return LocalTime
     * @return
     */
    private LocalTime getEndTimeSubInterval(int notificationsTriggered, LocalTime startTime, LocalTime endTime) {
        LocalTime endTimeReturn;
        if (notificationsTriggered == 0) {
            endTimeReturn = startTime.truncatedTo(ChronoUnit.HOURS).
                    plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);;
        } else if (notificationsTriggered == 1){
            endTimeReturn = startTime.truncatedTo(ChronoUnit.HOURS).
                    plusMinutes(Constants.INTERVAL_LENGTH_MINUTES);
            endTimeReturn = endTimeReturn.plus((long) Constants.INTERVAL_LENGTH_MINUTES *
                    notificationsTriggered, ChronoUnit.MINUTES);
        } else {
            endTimeReturn = endTime;
        }

        return endTimeReturn;
    }

}