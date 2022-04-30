package view;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Displayable;
import common.models.InputField;
import factory.ViewFactory;
import model.ExerciseViewModel;
import view.data.DataView;

import java.util.HashMap;

public class OnExerciseView extends DataView<ExerciseViewModel> {


    public OnExerciseView(HashMap<String, InputField> inputFields, ExerciseViewModel model, String screenTitle) {
        super(inputFields, model, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();
                displayExercise();
                returnToMainMenu();
                break;
        }
    }

    private void displayExercise() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(getModel().getExerciseName()).append(":\n")
                .append("\t").append("Reps:").append(getModel().getReps())
                .append("\t").append("Sets:").append(getModel().getSets())
                .append("\t").append("Duration minutes:").append(getModel().getExerciseTime())
                .append("\t").append("Level:").append(getModel().getLevel());

        System.out.println(stringBuilder);
    }

    @Override
    protected void returnToMainMenu() {
        // Trigger next notification
        Displayable displayable = ViewFactory.getView(getInputFields(), View.NOTIFICATION_VIEW);
        Display screen = Display.FAIL;

        displayable.display(screen);
    }
}
