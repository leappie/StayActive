package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.InputField;
import factory.ViewFactory;
import model.UserLoginViewModel;
import view.form.FormView;

import java.util.HashMap;
import java.util.InputMismatchException;

public class StartView extends FormView<UserLoginViewModel> {

    public StartView(HashMap<String, InputField> inputFields, Controller<UserLoginViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();
                displayInfo();
                Displayable displayable;

                try {
                    int choice = getScanner().nextInt();

                    switch (choice) {
                        case 1:
                            displayable = ViewFactory.getView(View.LOGIN_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 2:
                            // TODO: NEW ACCOUNT
                            displayable = ViewFactory.getView(View.NEW_ACCOUNT_VIEW);
                            displayable.display(Display.MAIN);
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
                    displayable = ViewFactory.getView(View.START_VIEW);
                    displayable.display(Display.MAIN);
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


}
