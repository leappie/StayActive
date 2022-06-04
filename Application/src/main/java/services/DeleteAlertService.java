package services;

import alert.AlertRepository;
import common.interfaces.daos.IAlertDAO;
import entity.Alert;
import entity.User;
import services.user.UserAlerts;

public class DeleteAlertService {
    private IAlertDAO alertDAO;
    private User loggedInUser;

    public DeleteAlertService(IAlertDAO alertDAO, User loggedInUser) {
        this.alertDAO = alertDAO;
        this.loggedInUser = loggedInUser;
    }

    public void deleteAlert(Alert alert) {
        // delete alert
        AlertRepository alertRepository = new AlertRepository(this.alertDAO);
        alertRepository.deleteAlert(alert);

        // update user alerts
        new UserAlerts().deleteAlert(loggedInUser, alert);


    }
}
