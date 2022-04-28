package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.ExerciseViewModel;
import amcode.consolui.view.data.DataView;
import amcode.consolui.view.form.input.InputField;

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
        Displayable displayable = ViewFactory.getView(getInputFields(), View.NOTIFICATION_VIEW);
        Display screen = Display.FAIL;

        displayable.display(screen);
    }
}
