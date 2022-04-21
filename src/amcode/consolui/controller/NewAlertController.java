package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;
import amcode.domain.model.User;
import amcode.domain.services.UserAlerts;

import java.util.HashMap;

public class NewAlertController implements Controller<Alert> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Alert model) {
        User user = (User) inputField.get("loggedInUser").getValue();
        FormView formView;
        Display display;

        UserAlerts userAlerts = new UserAlerts();
        Alert alert = userAlerts.tryAddAlert(user, model);
        //TODO: add alert in DB

        if (alert == null) {
            formView = ViewFactory.getView(inputField, View.NEW_ALERT_VIEW);
            display = Display.FAIL;
        } else {
            formView = ViewFactory.getView(inputField, View.ALERT_LIST_VIEW);
            display = Display.MAIN;
        }

        return new DisplayScreen(formView, display);
    }


}
