package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import factory.ViewFactory;
import model.NotificationViewModel;
import persistence.alertexercise.AlertExerciseDAO;
import services.TriggerAlertService;
import view.form.input.StringInputField;

import java.time.LocalTime;
import java.util.HashMap;

public class TriggerAlertController implements Controller<NotificationViewModel> {
    public static final String TAG = "TriggerAlertController";

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NotificationViewModel model) {
        Displayable displayable;
        Display display;

        // get alert
        User loggedInUser = CurrentUserService.getLoggedInUser();
        int chosenAlertIndex = (int) inputField.get("chosenAlertIndex").getValue();
        Alert alert = loggedInUser.getAlertList().get(chosenAlertIndex);

        // get notificationTime
        LocalTime notificationTime = new TriggerAlertService(new AlertExerciseDAO()).triggerAlert(alert); // TODO: improve?

        if (notificationTime != null) {
            inputField.put("notificationTime", new StringInputField(notificationTime.toString()));
            displayable = ViewFactory.getView(inputField, View.NOTIFICATION_VIEW);
            display = Display.MAIN;
        } else {
            displayable = ViewFactory.getView(inputField, View.ALERT_OPTIONS_VIEW);
            display = Display.MAIN;
        }

        return new DisplayScreen(displayable, display);
    }
}
