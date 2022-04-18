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

public class StartView extends FormView<User> {
    public StartView(HashMap<String, InputField> inputFields, Controller<User> controller) {
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
                            formView = ViewFactory.getView(View.LOGIN_VIEW);
                            formView.display(Display.MAIN);
                            break;
                        case 2:
                            formView = ViewFactory.getView(View.NEW_ACCOUNT_VIEW);
                            formView.display(Display.MAIN);
                            break;
                        case 3:
                            // TODO: FORGOT PASSWORD
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
                    formView = ViewFactory.getView(View.START_VIEW);
                    formView.display(Display.MAIN);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void displayInfo() {
        System.out.println(
                "Choose an option: \n" +
                        "\t1. Login.\n" +
                        "\t2. Create new account.\n" +
                        "\t3. Forgot password.\n" +
                        "\t4. Quit."
        );
    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
    }

}
