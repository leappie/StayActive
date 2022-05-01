package services.user;


import entity.Alert;
import entity.Interval;
import entity.User;
import interfaces.UserAlertsControl;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * This class manages how User alerts are created and modified.
 */
public class UserAlerts implements UserAlertsControl {
    public Alert addAlert(User user, Alert alert) {
        Interval interval = alert.getInterval();

        // Difference startTime and endTime must be greater than 0
        if (interval.getStartTime().until(interval.getEndTime(), ChronoUnit.MINUTES) <= 0) {
            return null;
        } else {
            // if no name entered, create new name
            alert = incrementAlertName(user, alert);

            // check name duplicates
            alert = checkNameDuplicate(user, alert);

            if (alert != null) {
                user.getAlertList().add(alert);
            }
            return alert;
        }
    }

    public Alert updateAlert(User user, Alert alert) {
        return null;
    }

    public void deleteAlert(User user, Alert alert) {
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

    private Alert checkNameDuplicate(User user, Alert alert) {
        String alertName = alert.getName();

        for (Alert userAlert : user.getAlertList()) {
            if (userAlert.getName().equals(alertName)) {
                return null;
            }
        }

        return alert;
    }
}
