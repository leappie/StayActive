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
import view.form.input.StringInputField;

import java.util.HashMap;

public class LoginView extends FormView<UserLoginViewModel> {

    public LoginView(HashMap<String, InputField> inputFields, Controller<UserLoginViewModel> controller, String screenTitle) {
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

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));

                DisplayScreen displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            case FAIL:
                System.out.println("Incorrect password or username.");

                displayable = ViewFactory.getView(getInputFields(), View.START_VIEW);
                displayable.display(Display.MAIN);
                break;
            default:
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserLoginViewModel> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        UserLoginViewModel userLoginViewModel = new UserLoginViewModel(username, password);

        return controller.execute(getInputFields(), userLoginViewModel);
    }

}
