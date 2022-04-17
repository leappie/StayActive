package amcode.view;

import amcode.controller.Controller;
import amcode.model.domain.User;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public class AlertListView extends FormView<User> {

    public AlertListView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(DisplayEnum display) {
        switch (display) {
            case MAIN:
                displayInfo();
                int choice = getScanner().nextInt();
                // TODO validate input
                FormView formView;

                switch (choice) {
                    case 1:
                        // TODO: add new alert
                        break;
                    case 2:
                        // TODO: modify alert
                        break;
                    case 3:
                        // TODO: back to mainview
                        break;
                    case 4:
                        // Quit
                        break;
                    default:
                        // Quit
                        break;
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {

    }

    @Override
    protected void displayInfo() {
        System.out.println(
                "Choose an option: +\n" +
                        "\t1. Add new alert." +
                        "\t2. Modify alert" +
                        "\t3. Back." +
                        "\t4. Quit."
        );
    }
}
