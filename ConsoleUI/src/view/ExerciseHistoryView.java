package view;

import common.enums.Display;
import common.interfaces.Controller;
import common.models.DisplayScreen;
import common.models.InputField;
import view.form.FormView;

import java.util.HashMap;

// TODO:
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
