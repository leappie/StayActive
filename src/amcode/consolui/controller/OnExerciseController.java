package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Exercise;

import java.util.HashMap;

public class OnExerciseController implements Controller<Exercise> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, Exercise model) {
        return null;
    }
}
