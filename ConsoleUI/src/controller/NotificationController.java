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
import enums.Level;
import factory.ViewFactory;
import model.ExerciseViewModel;
import model.NotificationViewModel;
import persistence.alertexercise.AlertExerciseDAO;
import services.NotificationService;
import services.alertexercise.AlertExercise;
import services.alertexercise.AlertExerciseCreatorA;
import services.intervalexerciselevel.ExerciseLevelCreatorA;
import services.intervalexerciselevel.IntervalExerciseLevel;
import view.OnExerciseView;

import java.util.HashMap;
import java.util.List;

public class NotificationController implements Controller<NotificationViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NotificationViewModel model) {
        Displayable displayable;
        Display screen;

        // get alert
        User loggedInUser = CurrentUserService.getLoggedInUser();
        int chosenAlertIndex = (int) inputField.get("chosenAlertIndex").getValue();
        Alert alert = loggedInUser.getAlertList().get(chosenAlertIndex);

//        Exercise exercise = new NotificationService(new AlertExerciseDAO()).getExerciseOnNotification(alert, loggedInUser); // TODO: improve?
        Exercise exercise = new NotificationService(new AlertExerciseDAO()).getExerciseOnNotification(alert); // TODO: improve?

        if (exercise != null) {
            // map exercise to viewModel
            ExerciseViewModel exerciseViewModel = new OnExerciseViewMapping().mapFrom(exercise);

            // show display
            displayable = new OnExerciseView(inputField, exerciseViewModel, "Todo exercise");
        } else  {
            displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
        }

        screen = Display.MAIN;

        return new DisplayScreen(displayable, screen);
    }
}
