package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import common.interfaces.daos.IAlertDAO;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import services.user.UserAlerts;

public class DeleteAlertService {
    private IAlertDAO alertDAO;

    public DeleteAlertService(IAlertDAO alertDAO) {
        this.alertDAO = alertDAO;
    }

    public void deleteAlert(Alert alert) {
        // delete alert
        AlertRepository alertRepository = new AlertRepository(this.alertDAO);
        alertRepository.deleteAlert(alert);

        // update user alerts
        User loggedInUser = CurrentUserService.getLoggedInUser();
        new UserAlerts().deleteAlert(loggedInUser, alert);


    }
}
