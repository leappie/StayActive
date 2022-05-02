package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.UserLoginViewModel;
import view.form.FormView;
import view.form.input.IntegerInputField;

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
                Display screen;

                try {
                    int choice = getScanner().nextInt();
                    getInputFields().put("startViewChoice", new IntegerInputField(choice));

                    DisplayScreen displayScreen = submit(getInputFields(), getController());
                    displayable = displayScreen.getFormView();
                    screen = displayScreen.getDisplay();

                    displayable.display(screen);


                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    displayable = ViewFactory.getView(View.START_VIEW);
                    displayable.display(Display.MAIN);
                }
                break;
            case FAIL:
                System.out.println("Invalid Option.");
                display(Display.MAIN);
                break;
            case QUIT:
                // quit
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserLoginViewModel> controller) {
        return controller.execute(inputFields, null);
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
