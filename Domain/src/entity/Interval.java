package entity;

import common.Constants;

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
    /*
     * The Interval intermediateInterval is used to divide the main interval in sub intervals. The intermediate interval
     * start and end time are updated when a notification has taken place.
     *
     */
    private Interval intermediateInterval; // used for calculating notification time

    public Interval(int id, LocalTime startTime, LocalTime endTime, List<Notification> notificationList, Interval intermediateInterval) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalNotifications = calcTotalNotifications();
        this.notificationsTriggered = Constants.DEFAULT_ZERO;
        this.notificationList = notificationList;
        this.intermediateInterval = intermediateInterval;
    }

    public Interval(int id, LocalTime startTime, LocalTime endTime, List<Notification> notificationList) {
        this(id, startTime, endTime, notificationList,
                new Interval(Constants.DEFAULT_ID, startTime, endTime, new ArrayList<>(), null));
    }

    public Interval(LocalTime startTime, LocalTime endTime) {
        this(Constants.DEFAULT_ID, startTime, endTime, new ArrayList<>());
    }

    public Interval(LocalTime startTime, LocalTime endTime, int notificationsTriggered) {
        this(Constants.DEFAULT_ID, startTime, endTime, new ArrayList<>());
        this.notificationsTriggered = notificationsTriggered;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        this.totalNotifications = calcTotalNotifications();
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
        this.totalNotifications = calcTotalNotifications();
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

    public Interval getIntermediateInterval() {
        return intermediateInterval;
    }

    public void setTotalNotifications(int totalNotifications) {
        this.totalNotifications = totalNotifications;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    /**
     * This methods calculates the total amount of notifications in a time interval.
     * The interval is divided bij 60 minutes and rounded up to the nearest integer.
     *
     * Returns 0, if one of the times is null.
     *
     * @return integer as totalNotifications
     */
    private int calcTotalNotifications() {
        if (this.startTime != null && this.endTime != null) {
            // if the end time is greater than start time continue
            if (startTime.compareTo(endTime) < 0) {
                double diffMinutes = this.startTime.until(this.endTime, ChronoUnit.MINUTES);
                return (int) Math.ceil(diffMinutes / Constants.INTERVAL_LENGTH_MINUTES);
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Interval: (" + startTime + "-" + endTime + ")|" + totalNotifications + "|" + notificationsTriggered + ":\n" +
                "\t" + notificationList;
    }
}
