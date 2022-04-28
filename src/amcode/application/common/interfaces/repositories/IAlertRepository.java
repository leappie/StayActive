package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Alert;

import java.util.List;

public interface IAlertRepository {
    long addAlert(Alert alert);
    long updateAlert(Alert alert);
    long removeAlert(Alert alert);

    List<Alert> getAlerts(Alert alert);


}
