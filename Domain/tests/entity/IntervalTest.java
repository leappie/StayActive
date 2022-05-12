package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class IntervalTest {

    @Test
    void getTotalNotifications() {
        // Arrange
        int hourStartTime = 9;
        int minutesStartTime = 59;
        int hourEndTime = 17;
        int minutesEndTime = 59;

        LocalTime startTime = LocalTime.of(hourStartTime, minutesStartTime);
        LocalTime endTime = LocalTime.of(hourEndTime, minutesEndTime);
        Interval interval = new Interval(startTime, endTime);

        // Act
        int totalNotifications = interval.getTotalNotifications();

        //Assert
        Assertions.assertEquals(9,totalNotifications);
    }
}