package amcode.domain.model;

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
        final double INTERVAL_LENGTH_MINUTES = 60;
        double diffMinutes = this.startTime.until(this.endTime, ChronoUnit.MINUTES);
        boolean intervalChecked = checkInterval(diffMinutes);

        if (intervalChecked) {
            return (int) Math.ceil(diffMinutes / INTERVAL_LENGTH_MINUTES);
        }
        return 0;
    }


    private boolean checkInterval(double value) {
        final double TWO_MINUTES = 2;

        /*
        An interval smaller than 2 minutes will give an error.
        The alert will be in minutes. So the alert will be the first or second minute.
        This will make sure that an interval is not negative: endTime > startTime
         */
        if (value <= TWO_MINUTES) {
            return false;
        }
        return true;
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
