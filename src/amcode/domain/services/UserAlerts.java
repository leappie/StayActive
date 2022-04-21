package amcode.domain.services;

import amcode.domain.model.Alert;
import amcode.domain.model.Interval;
import amcode.domain.model.User;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class UserAlerts {
    public Alert tryAddAlert(User user, Alert alert) {
        Interval interval = alert.getInterval();

        // Difference startTime and endTime must be greater than 0
        if (interval.getStartTime().until(interval.getEndTime(), ChronoUnit.MINUTES) <= 0) {
            return null;
        } else {
            // if no name entered, create new name
            alert = incrementAlertName(user, alert);

            user.getAlertList().add(alert);
            return alert;
        }
    }

    public Alert updateAlert(User user, Alert alert) {
        return null;
    }

    public boolean deleteAlert(User user, Alert alert) {
        return false;
    }

    private Alert incrementAlertName(User user, Alert alert) {
        String alertName = alert.getName();

        if (alertName.equals("")) {
            List<Alert> alertList = user.getAlertList();
            int alertNumber = alertList.size() + 1;
            alertName = "Alert " + alertNumber;
            alert.setName(alertName);
        }

        return alert;
    }
}
