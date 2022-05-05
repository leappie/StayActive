package services;

import alert.AlertRepository;
import common.enums.Display;
import common.enums.View;
import common.interfaces.DAO;
import common.mapping.OnExerciseViewMapping;
import common.services.ExerciseLevelService;
import entity.*;
import enums.Level;
import factory.ViewFactory;
import model.ExerciseViewModel;
import services.alertexercise.AlertExercise;
import services.alertexercise.AlertExerciseCreatorA;
import services.intervalexerciselevel.ExerciseLevelCreatorA;
import services.intervalexerciselevel.ExerciseLevelCreatorB;
import services.intervalexerciselevel.IntervalExerciseLevel;
import view.OnExerciseView;

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
