package amcode.application.common.interfaces.repositories;

import amcode.domain.model.Alert;

public interface AlertRepository {
    Alert getAlert(int id);
    Alert getAlert(Alert alert);
    boolean addAlert(Alert alert);
    boolean updateAlert(Alert alert);
    boolean deleteAlert(Alert alert);


}
