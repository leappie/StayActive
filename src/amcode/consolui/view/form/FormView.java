package amcode.consolui.view.form;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.interfaces.Submittable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;
import java.util.Scanner;

public abstract class FormView<T> implements Displayable, Submittable<T> {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, InputField> inputFields;
    private Controller<T> controller;
    private String screenTitle;

    public FormView(HashMap<String, InputField> inputFields, Controller<T> controller, String screenTitle) {
        this.controller = controller;
        this.inputFields = inputFields;
        this.screenTitle = screenTitle;
    }

    protected void displayInfo() {
        System.out.println(
                "Choose an option: \n" +
                        "\t1. View profile.\n" +
                        "\t2. View alerts.\n" +
                        "\t3. View exercise history.\n" +
                        "\t4. Quit."
        );
    }

    public Scanner getScanner() {
        return scanner;
    }

    public HashMap<String, InputField> getInputFields() {
        return inputFields;
    }

    public Controller<T> getController() {
        return controller;
    }

    protected void createTitle() {
        final int TOTAL_CHARS = 30;
        int totalCharsLeft = TOTAL_CHARS - this.screenTitle.length();
        int charsRightSide = totalCharsLeft / 2;
        int charsLeftSide;
        StringBuilder stringBuilder = new StringBuilder();

        if (charsRightSide == (totalCharsLeft - charsRightSide)) {
            // even chars each side
            charsLeftSide = charsRightSide;
        } else {
            // uneven chars each side
            charsLeftSide = charsRightSide + 1;
        }

        for (int i = 1; i < charsLeftSide; i++) {
            if (i == charsLeftSide - 1) {
                stringBuilder.append(" ");
            } else if (i == charsLeftSide - 2) {
                stringBuilder.append(">");
            } else {
                stringBuilder.append("-");
            }
        }
        stringBuilder.append(this.screenTitle);

        for (int i = 1; i < charsLeftSide; i++) {
            if (i == 1) {
                stringBuilder.append(" ");
            } else if (i == 2) {
                stringBuilder.append("<");
            } else {
                stringBuilder.append("-");
            }
        }

        System.out.println(stringBuilder);
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<T> controller) {
        return null;
    }
}
