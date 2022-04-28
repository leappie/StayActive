package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.ExerciseViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class OnExerciseController implements Controller<ExerciseViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, ExerciseViewModel model) {
        return null;
    }
}
