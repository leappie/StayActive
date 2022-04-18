package amcode.consolui.view.form;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.interfaces.Submittable;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;
import java.util.Scanner;

public abstract class FormView<T> implements Displayable, Submittable<T> {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, InputField> inputFields;
    private Controller<T> controller;

    public FormView(HashMap<String, InputField> inputFields, Controller<T> controller) {
        this.controller = controller;
        this.inputFields = inputFields;
    }

    protected void displayInfo() {
        System.out.println(
                "Choose an option: +\n" +
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
}
