package view;

import common.enums.Display;
import common.models.InputField;
import view.data.DataView;

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
