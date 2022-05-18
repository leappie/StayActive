package common.interfaces.daos;

import entity.Alert;
import entity.User;

import java.util.List;

public interface IAlertExerciseDAO {

    long insert(Alert alert);
    long update(Alert alert);
    void delete(Alert alert);
    List<Alert> query(Alert alert);

}
