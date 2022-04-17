package amcode.controller;


import amcode.model.domain.User;
import amcode.view.form.Displayable;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public class AlertListController implements Controller<User> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        return null;
    }
}
