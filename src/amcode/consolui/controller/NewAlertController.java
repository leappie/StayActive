package amcode.consolui.controller;

import amcode.application.alert.AlertExerciseRepository;
import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.application.exercise.ExerciseRepository;
import amcode.application.user.UserAlertRepository;
import amcode.consolui.common.mapping.AlertViewMapping;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Exercise;
import amcode.domain.entity.User;
import amcode.domain.services.user.UserAlerts;
import amcode.infrastructure.persistence.sql.alertexercise.AlertExerciseDao;
import amcode.infrastructure.persistence.sql.exercise.ExerciseDao;
import amcode.infrastructure.persistence.sql.useralert.UserAlertDao;

import java.util.HashMap;
import java.util.List;

public class NewAlertController implements Controller<AlertViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, AlertViewModel model) {
        Displayable displayable;
        Display display;

        // map alertViewModel to alert
        Alert alert = new AlertViewMapping().mapTo(model);

        // check if mapping succeeded
        if (alert == null) {
            displayable = ViewFactory.getView(inputField, View.NEW_ALERT_VIEW);
            display = Display.FAIL;
        } else {
            // add alert to loggedInUser
            User loggedInUser = CurrentUserService.getLoggedInUser();
            alert = new UserAlerts().tryAddAlert(loggedInUser, alert);

            if (alert != null) {
                // get all exercises to pair with alert
                List<Exercise> exerciseList = new ExerciseRepository(new ExerciseDao()).getAllExercises(null);

                // add alert to db
                new UserAlertRepository(new UserAlertDao()).addUserAlert(loggedInUser);

                // get back updated user
                loggedInUser = new UserAlertRepository(new UserAlertDao()).getUserAlerts(loggedInUser);
                CurrentUserService.setLoggedInUser(loggedInUser);

                // get last alert (id needed)
                int size = loggedInUser.getAlertList().size();
                Alert checkAlert = loggedInUser.getAlertList().get(size - 1);

                // pair exercises to alert
                checkAlert.setExerciseList(exerciseList);
                System.out.println(loggedInUser);

                // add to alert_exercise table -> pairing exercise weight to alert in db
                new AlertExerciseRepository(new AlertExerciseDao()).addAlertExercise(checkAlert);

                displayable = ViewFactory.getView(inputField, View.ALERT_OPTIONS_VIEW);
                display = Display.MAIN;
            } else {
                inputField.put("nameFail", new StringInputField("true"));
                displayable = ViewFactory.getView(inputField, View.NEW_ALERT_VIEW);
                display = Display.FAIL;
            }
        }


        return new DisplayScreen(displayable, display);
    }


}
