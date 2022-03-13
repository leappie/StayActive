package com.example.stayactive.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "alert")
public class Alert {
    @PrimaryKey
    private int alertId;

    private String name;
    private Date start; // start and end time when the alerts should go off
    private Date  end;
    private boolean isActive; // if an alert is active/ in use

    @Ignore
    private static final int DEFAULT_ID = 0; // when I create new alert default ID
    /*
    Default constructor
     */
    public Alert(int alertId, String name, Date  start, Date  end, boolean isActive) {
        this.alertId = alertId;
        this.name = name;
        this.start = start;
        this.end = end;
        this.isActive = isActive;
    }

    /*
    Constructor without id.
    Used when I create a new alert
    The default id will be automatically incremented.
     */
    public Alert(String name, Date  start, Date  end, boolean isActive) {
        this(DEFAULT_ID, name, start, end, isActive);
    }

    public int getAlertId() {
        return alertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date  getStart() {
        return start;
    }

    /*
    Whenever you want to change the start time
     */
    public void setStart(Date  start) {
        this.start = start;
    }

    public Date  getEnd() {
        return end;
    }

    /*
    Whenever you want to change the end time
     */
    public void setEnd(Date  end) {
        this.end = end;
    }

    public boolean isActive() {
        return isActive;
    }

    /*
    If you want to turn on/off the alert
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /*
    Needs to be overridden to be able to compare two alerts.
    This is used when filling the recyclerview list.
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            final Alert alert = (Alert) obj;

            if (this.getAlertId() != alert.getAlertId()) {
                return false;
                // same id hence same item, check if something has changed
            } else {
                return this.getName().equals(alert.getName()) &&
                        this.getStart() == alert.getStart() &&
                        this.getEnd() == alert.getEnd() &&
                        this.isActive() == alert.isActive();
            }
        }
        // item is the same
    }
}
