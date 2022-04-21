package amcode.domain.model;

import amcode.domain.common.Constants;

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

    public LocalTime getNotificationTime() {
        return notificationTime;
    }
}
