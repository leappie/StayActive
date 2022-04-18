package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;
import amcode.domain.model.User;
import amcode.domain.services.UserAlerts;

import java.util.HashMap;

public class NewAlertController implements Controller<Alert> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, Alert model) {
        User user = (User) inputField.get("loggedInUser").getValue();

        UserAlerts userAlerts = new UserAlerts();
        userAlerts.tryAddAlert(user, model);

        FormView formView = ViewFactory.getView(inputField, View.ALERT_LIST_VIEW);
        formView.display(Display.MAIN);

        return formView;
    }


}
