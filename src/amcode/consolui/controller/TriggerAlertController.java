package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;

import java.util.HashMap;

public class TriggerAlertController implements Controller<Alert> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Alert model) {
        FormView formView;
        Display display;

        // TODO: calculate notification time
        // TODO: display notification
        // TODO: if notification accepted, show exercise
        // TODO: if notification rejected, modify alert difficulty
//        if (user != null) {
//            inputField.put("loggedInUser", new UserInputField(user));
//            formView = ViewFactory.getView(inputField, View.MAIN_VIEW);
//            display = Display.MAIN;
//        } else {
//            formView = ViewFactory.getView(inputField,this, View.LOGIN_VIEW);
//            display = Display.FAIL;
//        }
//        return new DisplayScreen(formView, display);
        return null;
    }
}
