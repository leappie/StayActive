package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class IntervalTest {

    @Test
    void calcTotalNotificationsTest() {
        // Arrange
        final int hourStartTime = 9;
        final int minutesStartTime = 59;
        final int hourEndTime = 17;
        final int minutesEndTime = 59;

        LocalTime startTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);

        // Act
        int totalNotifications = interval.getTotalNotifications();

        //Assert
        Assertions.assertEquals(9,totalNotifications);
    }
}