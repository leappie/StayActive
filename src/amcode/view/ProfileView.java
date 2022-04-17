package amcode.view;

import amcode.controller.Controller;
import amcode.model.domain.User;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public class ProfileView extends FormView<User> {
    public ProfileView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(DisplayEnum display) {

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {

    }
}
