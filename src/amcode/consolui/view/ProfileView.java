package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class ProfileView extends FormView<User> {
    public ProfileView(HashMap<String, InputField> inputFields, Controller<User> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        return null;
    }
}