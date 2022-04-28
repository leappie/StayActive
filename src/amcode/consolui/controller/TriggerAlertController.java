package amcode.consolui.controller;

import amcode.application.alert.AlertExerciseRepository;
import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.NotificationViewModel;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;
import amcode.domain.entity.Notification;
import amcode.domain.entity.User;
import amcode.domain.services.intervalnotification.IntervalNotification;
import amcode.domain.services.intervalnotification.NotificationTimeCreatorB;
import amcode.infrastructure.persistence.sql.alertexercise.AlertExerciseDao;

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

        // get all exercise + weights paired to alert
        alert = new AlertExerciseRepository(new AlertExerciseDao()).getAlertExercises(alert);

        // calculate notification time
        Interval interval = alert.getInterval();
        IntervalNotification intervalNotification = new IntervalNotification(new NotificationTimeCreatorB());
        LocalTime notificationTime = intervalNotification.calcNextNotificationTime(interval);

        // add notification to interval notificationList
        if (notificationTime != null) {
            // all notification are triggered or can't be triggered if null
            inputField.put("notificationTime", new StringInputField(notificationTime.toString()));
            interval.getNotificationList().add(new Notification(notificationTime));

            displayable = ViewFactory.getView(inputField, View.NOTIFICATION_VIEW);
            display = Display.MAIN;
        } else {
            // reset triggers
            interval.setNotificationsTriggered(0);
            interval.getIntermediateInterval().setStartTime(interval.getStartTime());
            interval.getIntermediateInterval().setEndTime(interval.getEndTime());

            displayable = ViewFactory.getView(inputField, View.ALERT_OPTIONS_VIEW);
            display = Display.MAIN;
        }

        return new DisplayScreen(displayable, display);
    }
}
