package amcode.domain.services.user;

import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;
import amcode.domain.entity.User;

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
