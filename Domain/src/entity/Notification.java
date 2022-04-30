package entity;

import common.Constants;

import java.time.LocalTime;

public class Notification {
    private int id;
    private LocalTime notificationTime;
    private boolean accepted;

    public Notification(int id, LocalTime notificationTime, boolean accepted) {
        this.id = id;
        this.notificationTime = notificationTime;
        this.accepted = accepted;
    }

    public Notification(LocalTime notificationTime, boolean accepted) {
        this(Constants.DEFAULT_ID, notificationTime, accepted);
    }

    public Notification(LocalTime notificationTime) {
        this(notificationTime, Constants.DEFAULT_ACCEPTED);
    }

    public LocalTime getNotificationTime() {
        return notificationTime;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return notificationTime + "->" + accepted;
    }
}
