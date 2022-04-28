package amcode.application.common.interfaces.daos;

import amcode.domain.entity.Alert;

import java.util.List;

public interface IAlertDao {
    long insertUserAlert(Alert alert);
    long updateAlert(Alert alert);
    long deleteAlert(Alert alert);

    List<Alert> getAlerts(Alert alert);
}
