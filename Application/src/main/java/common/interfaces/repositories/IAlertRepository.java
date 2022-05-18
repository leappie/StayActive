package common.interfaces.repositories;

import entity.Alert;

import java.util.List;

public interface IAlertRepository {
    long updateAlert(Alert alert);
    void deleteAlert(Alert alert);
    List<Alert> getAllAlerts();

}
