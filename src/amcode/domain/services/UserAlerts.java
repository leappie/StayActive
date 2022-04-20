package amcode.domain.services;

import amcode.domain.model.Alert;
import amcode.domain.model.User;

import java.util.List;

public class UserAlerts {
    public Alert tryAddAlert(User user, Alert alert) {
        //TODO: check alert interval startTime cant be equal to endTime
        alert = incrementAlertName(user, alert);
        user.getAlertList().add(alert);
        return alert;
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
