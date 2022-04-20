package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class MainController implements Controller<User> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, User model) {
        return null;
    }
}
