package view;

import common.enums.Display;
import common.interfaces.Controller;
import common.models.DisplayScreen;
import common.models.InputField;
import view.data.DataView;
import view.form.FormView;

import java.util.HashMap;

// TODO:
public class ExerciseHistoryView extends DataView<ExerciseHistoryView> {

    public ExerciseHistoryView(HashMap<String, InputField> inputFields, ExerciseHistoryView model, String screenTitle) {
        super(inputFields, model, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

}
