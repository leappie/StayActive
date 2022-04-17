package amcode.consolui.controller;

import amcode.application.interfaces.Controller;
import amcode.application.interfaces.Displayable;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class ExerciseHistoryController implements Controller<User> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        return null;
    }
}
