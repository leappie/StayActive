package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;

import java.util.HashMap;

public class NotificationController implements Controller<Alert> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Alert model) {
        return null;
    }
}
