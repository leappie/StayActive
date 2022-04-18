package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class ExerciseHistoryView extends FormView<User> {
    public ExerciseHistoryView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {

    }
}
