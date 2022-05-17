package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.mapping.OnExerciseViewMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.*;
import factory.ViewFactory;
import model.ExerciseViewModel;
import model.NotificationViewModel;
import persistence.alertexercise.AlertExerciseDAO;
import services.NotificationService;
import view.OnExerciseView;

import java.util.HashMap;

public class NotificationController implements Controller<NotificationViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NotificationViewModel model) {
        Displayable displayable;
        Display screen;

        String choice = (String) inputField.get("notificationViewChoice").getValue();

        // validate choice
        if (choice.equalsIgnoreCase("y")) { // Show exercise
            // get alert
            User loggedInUser = CurrentUserService.getLoggedInUser();
            int chosenIndex = (int) inputField.get("alertIndexChoice").getValue();
            Alert chosenAlert = loggedInUser.getAlertList().get(chosenIndex - 1);

            // get exercise
//            Exercise exercise = new NotificationService(new AlertExerciseDAO()).getExerciseOnNotification(chosenAlert, loggedInUser); // TODO: improve?
            Exercise exercise = new NotificationService(new AlertExerciseDAO()).getExerciseOnNotification(chosenAlert); // TODO: improve?

            if (exercise != null) {
                // map exercise to viewModel
                ExerciseViewModel exerciseViewModel = new OnExerciseViewMapping().mapToModel(exercise);

                // show display
                displayable = new OnExerciseView(inputField, exerciseViewModel, "Todo exercise");
            } else  {
                displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
            }
            screen = Display.MAIN;
        } else if (choice.equalsIgnoreCase("n")) { // Trigger next notification
            displayable = ViewFactory.getView(inputField, View.TRIGGER_ALERT_VIEW);
            screen = Display.SUCCESS;
        } else { // invalid choice
            displayable = ViewFactory.getView(inputField, View.NOTIFICATION_VIEW);
            screen = Display.FAIL;

        }
        return new DisplayScreen(displayable, screen);
    }

}
