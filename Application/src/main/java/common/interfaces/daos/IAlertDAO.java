package common.interfaces.daos;

import entity.Alert;

import java.util.List;

public interface IAlertDAO {

    long update(Alert alert);
    void delete(Alert alert);
    List<Alert> queryAll();


}
