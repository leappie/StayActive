package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.mapping.AlertViewMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.Alert;
import entity.Exercise;
import entity.User;
import factory.ViewFactory;
import model.AlertViewModel;
import persistence.alertexercise.AlertExerciseDAO;
import persistence.exercise.ExerciseDAO;
import persistence.useralert.UserAlertDAO;
import services.ExerciseService;
import services.NewAlertService;
import services.user.UserAlerts;

import java.util.HashMap;
import java.util.List;

public class NewAlertController implements Controller<AlertViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, AlertViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        // map alertViewModel to alert
        Alert alert = new AlertViewMapping().mapTo(model);

        // check if mapping succeeded
        if (alert == null) {
            // failed on time interval
            view = View.NEW_ALERT_VIEW;
            screen = Display.FAIL;
        } else {
            // add alert to loggedInUser
            User loggedInUser = CurrentUserService.getLoggedInUser();
            alert = new UserAlerts().addAlert(loggedInUser, alert);

            if (alert != null) {
                // get all exercises to pair with alert
                List<Exercise> exerciseList = new ExerciseService(new ExerciseDAO()).getAllExercises();// TODO: improve?

                // add new alert
                new NewAlertService(new UserAlertDAO(), new AlertExerciseDAO()).AddNewAlert(loggedInUser, exerciseList); // TODO: improve?

                view = View.ALERT_OPTIONS_VIEW;
                screen = Display.MAIN;
            } else {
                // failed on duplicate name
                view = View.NEW_ALERT_VIEW;
                screen = Display.FAIL;
            }
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }


}
