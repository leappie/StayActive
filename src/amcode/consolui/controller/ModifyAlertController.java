package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.NewUserViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class ModifyAlertController implements Controller<NewUserViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NewUserViewModel model) {
        return null;
    }
}
