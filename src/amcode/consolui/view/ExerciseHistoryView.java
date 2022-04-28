package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class ExerciseHistoryView extends FormView<ExerciseHistoryView> {
    public ExerciseHistoryView(HashMap<String, InputField> inputFields, Controller<ExerciseHistoryView> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<ExerciseHistoryView> controller) {
        return null;
    }
}
