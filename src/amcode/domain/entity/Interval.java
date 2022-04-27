package amcode.domain.entity;

import amcode.domain.common.Constants;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Interval {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalNotifications;
    private int notificationsTriggered;
    private List<Notification> notificationList;

    public Interval(int id, LocalTime startTime, LocalTime endTime, List<Notification> notificationList) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalNotifications = calcTotalNotifications();
        this.notificationsTriggered = 0;
        this.notificationList = notificationList;
    }

    public Interval(LocalTime startTime, LocalTime endTime) {
        this(Constants.DEFAULT_ID, startTime, endTime, new ArrayList<>());
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTotalNotifications() {
        return totalNotifications;
    }

    public int getNotificationsTriggered() {
        return notificationsTriggered;
    }

    public void setNotificationsTriggered(int notificationsTriggered) {
        this.notificationsTriggered = notificationsTriggered;
    }

    private int calcTotalNotifications() {
        if (this.startTime != null && this.endTime != null) {
            // if the end time is greater or equal to start time return 0
            if (startTime.compareTo(endTime) > 0) {
                double diffMinutes = this.startTime.until(this.endTime, ChronoUnit.MINUTES);
                return (int) Math.ceil(diffMinutes / Constants.INTERVAL_LENGTH_MINUTES);
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Interval{" + "\n" +
                "startTime=" + startTime + "\n" +
                ", endTime=" + endTime + "\n" +
                ", totalNotifications=" + totalNotifications + "\n" +
                ", notificationsTriggered=" + notificationsTriggered + "\n" +
                ", notificationList=" + notificationList + "\n" +
                '}';
    }
}
