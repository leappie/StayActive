package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;

import java.util.HashMap;

public class NewAlertController implements Controller<Alert> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, Alert model) {
        return null;
    }
}
