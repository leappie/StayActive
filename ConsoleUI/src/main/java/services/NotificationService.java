package services;

import alert.AlertRepository;
import alertexercise.AlertExerciseRepository;
import common.interfaces.DAO;
import common.interfaces.daos.IAlertExerciseDAO;
import common.interfaces.repositories.IAlertExerciseRepository;
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
    private IAlertExerciseDAO alertExerciseDAO;

    public NotificationService(IAlertExerciseDAO alertExerciseDAO) {
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
            IAlertExerciseRepository alertExerciseRepository = new AlertExerciseRepository(this.alertExerciseDAO);
            alertExerciseRepository.updateAlertExercise(alert);
        }
        return exercise;
    }
}
