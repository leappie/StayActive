package interfaces;

import entity.Alert;
import entity.User;

public interface UserAlertsControl {
    Alert addAlert(User user, Alert alert);
    Alert updateAlert(User user, Alert alert);
    void deleteAlert(User user, Alert alert);
}
