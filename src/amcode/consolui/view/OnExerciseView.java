package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.ExerciseViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class OnExerciseView extends FormView<ExerciseViewModel> {


    public OnExerciseView(HashMap<String, InputField> inputFields, Controller<ExerciseViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<ExerciseViewModel> controller) {
        return null;
    }
}
