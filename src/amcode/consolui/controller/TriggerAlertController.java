package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;
import amcode.domain.entity.User;
import amcode.domain.services.intervalnotification.IntervalNotification;
import amcode.domain.services.intervalnotification.NotificationTimeCreatorB;

import java.time.LocalTime;
import java.util.HashMap;

public class TriggerAlertController implements Controller<AlertViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, AlertViewModel model) {
        Displayable displayable;
        Display display;

        // get alert
        User loggedInUser = CurrentUserService.getLoggedInUser();
        int chosenAlertIndex = (int) inputField.get("chosenAlertIndex").getValue();
        Alert alert = loggedInUser.getAlertList().get(chosenAlertIndex);

        // calculate notification time
        Interval interval = alert.getInterval();
        IntervalNotification intervalNotification = new IntervalNotification(new NotificationTimeCreatorB());
        LocalTime notificationTime = intervalNotification.calcNextNotificationTime(interval);
        inputField.put("notificationTime", new StringInputField(notificationTime.toString()));

        displayable = ViewFactory.getView(inputField, View.NOTIFICATION_VIEW);
        display = Display.MAIN;

        return new DisplayScreen(displayable, display);
    }
}
