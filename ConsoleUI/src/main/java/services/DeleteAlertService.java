package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import services.user.UserAlerts;

public class DeleteAlertService {
    private DAO<Alert> alertDAO;

    public DeleteAlertService(DAO<Alert> alertDAO) {
        this.alertDAO = alertDAO;
    }

    public void deleteAlert(Alert alert) {
        // delete alert
        AlertRepository alertRepository = new AlertRepository(this.alertDAO);
        alertRepository.remove(alert);

        // update user alerts
        User loggedInUser = CurrentUserService.getLoggedInUser();
        new UserAlerts().deleteAlert(loggedInUser, alert);


    }
}
