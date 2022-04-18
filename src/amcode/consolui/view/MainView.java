package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;

import java.util.HashMap;
import java.util.InputMismatchException;

public class MainView extends FormView<User> {

    public MainView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                displayInfo();
                FormView formView;

                try {
                    int choice = getScanner().nextInt();

                    switch (choice) {
                        case 1:
                            // TODO: view profile
                            System.out.println("Nothing to find here ...");
                            display(Display.MAIN);
                            break;
                        case 2:
                            /*
                            use same input fields to include logged_in_user
                             */
                            formView = ViewFactory.getView(getInputFields(), View.ALERT_LIST_VIEW);
                            formView.display(Display.MAIN);
                            break;
                        case 3:
                            // TODO: view exercise history
                            System.out.println("Nothing to find here ...");
                            display(Display.MAIN);
                            break;
                        case 4:
                            // Quit
                            break;
                        default:
                            System.out.println("Invalid Option.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    formView = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                    formView.display(Display.MAIN);
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
    }
}
