package amcode.application.common.dtos;

import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.List;

public class UserAlertsDTO {
    private User user;
    private List<Alert> alertList;

    public UserAlertsDTO(User user, List<Alert> alertList) {
        this.user = user;
        this.alertList = alertList;
    }

    public User getUser() {
        return user;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    @Override
    public String toString() {
        return "UserAlertsDTO{" +
                "user=" + user +
                ", alertList=" + alertList +
                '}';
    }
}
