package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.consolui.model.ExerciseViewModel;
import amcode.consolui.view.data.DataView;

public class OnExerciseView extends DataView<ExerciseViewModel> {

    public OnExerciseView(ExerciseViewModel model, String screenTitle) {
        super(model, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                displayExercise();
                returnToMainMenu();
                break;
        }
    }

    private void displayExercise() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("\t").append(getModel().getExerciseName()).append(":\n")
                .append("\t").append("Reps:").append(getModel().getReps())
                .append("\t").append("Sets:").append(getModel().getSets())
                .append("\t").append("Duration minutes:").append(getModel().getExerciseTime())
                .append("\t").append("Level:").append(getModel().getLevel());

    }
}
