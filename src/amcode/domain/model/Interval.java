package amcode.domain.model;

import amcode.domain.common.Constants;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Interval {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalNotifications;
    private int notificationsTriggered;

    public Interval(int id, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalNotifications = calcTotalNotifications();
        this.notificationsTriggered = 0;
    }

    public Interval(LocalTime startTime, LocalTime endTime) {
        this(Constants.DEFAULT_ID, startTime, endTime);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    private int calcTotalNotifications() {
        if (this.startTime != null && this.endTime != null) {
            double diffMinutes = this.startTime.until(this.endTime, ChronoUnit.MINUTES);

            return (int) Math.ceil(diffMinutes / Constants.INTERVAL_LENGTH_MINUTES);
        }
        return 0;
    }


    public LocalTime calcNextNotificationTime() {
        final int ONE_NOTIFICATION = 1;
        LocalTime alertLow;
        LocalTime alertHigh;

        if (this.totalNotifications == ONE_NOTIFICATION) {
            alertLow = this.startTime;
            alertHigh = this.endTime;
        } else {

        }



        return null;
    }


}
