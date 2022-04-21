package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.TimeInputField;
import amcode.domain.model.Alert;
import amcode.domain.model.Interval;

import java.time.LocalTime;
import java.util.HashMap;

public class TriggerAlertController implements Controller<Alert> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Alert model) {
        FormView formView;
        Display display;

        // calculate notification time
        Alert chosenAlert = (Alert) inputField.get("chosenTriggerAlert").getValue();
        Interval interval = chosenAlert.getInterval();
        LocalTime notificationTime = interval.calcNextNotificationTime();
        inputField.put("notificationTime", new TimeInputField(notificationTime));

        formView = ViewFactory.getView(View.NOTIFICATION_VIEW);
        display = Display.MAIN;

        return new DisplayScreen(formView, display);
    }
}
