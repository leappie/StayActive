package view.data;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Displayable;
import common.models.InputField;
import factory.ViewFactory;

import java.util.HashMap;
import java.util.Scanner;

public abstract class DataView<T> implements Displayable {
    private Scanner scanner = new Scanner(System.in);
    private T model;
    private String screenTitle;
    private HashMap<String, InputField> inputFields;

    public DataView(HashMap<String, InputField> inputFields, T model, String screenTitle) {
        this.model = model;
        this.screenTitle = screenTitle;
        this.inputFields = inputFields;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public T getModel() {
        return model;
    }

    public HashMap<String, InputField> getInputFields() {
        return inputFields;
    }

    protected void returnToMainMenu() {
        Displayable displayable = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
        Display screen = Display.MAIN;

        displayable.display(screen);
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
}
