package amcode.consolui.view.data;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.factory.ViewFactory;

import java.util.Scanner;

public abstract class DataView<T> implements Displayable {
    private Scanner scanner = new Scanner(System.in);
    private T model;
    private String screenTitle;

    public DataView(T model, String screenTitle) {
        this.model = model;
        this.screenTitle = screenTitle;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public T getModel() {
        return model;
    }

    protected void returnToMainMenu() {
        Displayable displayable = ViewFactory.getView(View.MAIN_VIEW);
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
