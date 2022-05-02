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
import java.util.List;

public class TriggerAlertController implements Controller<NotificationViewModel> {
    public static final String TAG = "TriggerAlertController";

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NotificationViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        int chosenIndex = (int) inputField.get("alertIndexChoice").getValue();
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        // validate choice
        if (chosenIndex < 1 || chosenIndex > alertList.size()) {
            view = View.TRIGGER_ALERT_VIEW;
            screen = Display.FAIL;
        } else {
            // get alert
            Alert chosenAlert = loggedInUser.getAlertList().get(chosenIndex);

            // get notificationTime
            LocalTime notificationTime = new TriggerAlertService(new AlertExerciseDAO()).triggerAlert(chosenAlert); // TODO: improve?

            if (notificationTime != null) {
                inputField.put("notificationTime", new StringInputField(notificationTime.toString()));
                view = View.NOTIFICATION_VIEW;
                screen = Display.MAIN;
            } else {
                // not notifications to trigger
                view = View.ALERT_OPTIONS_VIEW;
                screen = Display.MAIN;
            }
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }

}
