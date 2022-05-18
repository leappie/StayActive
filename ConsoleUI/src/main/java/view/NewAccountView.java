package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.NewUserViewModel;
import view.form.FormView;
import view.form.input.StringInputField;

import java.util.HashMap;

public class NewAccountView extends FormView<NewUserViewModel> {
    public NewAccountView(HashMap<String, InputField> inputFields, Controller<NewUserViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        Displayable displayable;
        Display screen;

        switch (display) {
            case MAIN:
                createTitle();

                System.out.println("Enter username: ");
                String username = getScanner().nextLine();
                System.out.println("Enter password: ");
                String password = getScanner().nextLine();
                System.out.println("Choose level: easy or medium? [E/M]");
                String level = getScanner().nextLine();

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));
                getInputFields().put("level", new StringInputField(level));

                DisplayScreen displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            case FAIL:
                System.out.println("Username is taken.");

                displayable = ViewFactory.getView(getInputFields(), View.START_VIEW);
                displayable.display(Display.MAIN);
                break;
            case SUCCESS:
                System.out.println("Invalid level.");

                displayable = ViewFactory.getView(getInputFields(), View.START_VIEW);
                displayable.display(Display.MAIN);
                break;
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NewUserViewModel> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        final String level = (String) getInputFields().get("level").getValue();
        NewUserViewModel newUserViewModel = new NewUserViewModel(username, password, level);

        return controller.execute(getInputFields(), newUserViewModel);
    }

}