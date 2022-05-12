package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import common.services.ExerciseLevelService;
import entity.Alert;
import entity.Exercise;
import entity.Interval;
import entity.User;
import enums.Level;
import services.alertexercise.AlertExercise;
import services.alertexercise.AlertExerciseCreatorA;

import java.util.List;

public class NotificationService {
    private DAO<Alert> alertExerciseDAO;

    public NotificationService(DAO<Alert> alertExerciseDAO) {
        this.alertExerciseDAO = alertExerciseDAO;
    }

    public Exercise getExerciseOnNotification(Alert alert, User user) {
        // get interval
        Interval interval = alert.getInterval();

        // get exercise level
        List<Level> levelList;

        if (user == null) {
            levelList = new ExerciseLevelService().getExerciseLevel(interval);
        } else {
            levelList = new ExerciseLevelService().getExerciseLevel(interval, user);
        }

        // get exercise
        Exercise exercise = getExercise(levelList, alert);

        return exercise;
    }

    public Exercise getExerciseOnNotification(Alert alert) {
        return getExerciseOnNotification(alert, null);
    }


    private Exercise getExercise(List<Level> levelList, Alert alert) {
        Exercise exercise = null;

        if (levelList.size() > 0) {
            // get exercise
            exercise = new AlertExercise(new AlertExerciseCreatorA()).getExerciseOnNotification(alert, levelList);

            // update exercise weight
            AlertRepository alertRepository = new AlertRepository(this.alertExerciseDAO);
            alertRepository.update(alert);
        }
        return exercise;
    }
}
