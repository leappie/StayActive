package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import entity.Alert;
import entity.Exercise;
import exercise.ExerciseRepository;

import java.util.List;

public class DeleteAlertService {
    private DAO<Alert> alertDAO;

    public DeleteAlertService(DAO<Alert> alertDAO) {
        this.alertDAO = alertDAO;
    }

    public void deleteAlert(Alert alert) {
        AlertRepository alertRepository = new AlertRepository(this.alertDAO);
        alertRepository.remove(alert);

    }
}
