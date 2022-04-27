package amcode.application.common.interfaces.repositories;

import amcode.domain.entity.Alert;

public interface IAlertRepository {
    void addAlert(Alert alert);
    void updateAlert(Alert alert);
    void removeAlert(Alert alert);




}
