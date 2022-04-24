package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.LevelInputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.enums.Level;
import amcode.domain.entity.User;

import java.util.HashMap;

public class NewAccountView extends FormView<User> {
    public NewAccountView(HashMap<String, InputField> inputFields, Controller<User> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        String username;
        String password;
        switch (display) {
            case MAIN:
                createTitle();

                System.out.println("Set username: ");
                username = getScanner().nextLine();
                System.out.println("Set password: ");
                password = getScanner().nextLine();

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));

                displayInputLevel();
                break;
            case FAIL:
                displayInputLevel();
                break;
            case SUCCESS:
                DisplayScreen displayScreen = submit(getInputFields(), getController());
                FormView formView = (FormView) displayScreen.getFormView();
                Display screen = displayScreen.getDisplay();

                formView.display(screen);
                break;
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        final Level level = (Level) getInputFields().get("userLevel").getValue();

        User user = new User(username, password, level);

        return controller.execute(getInputFields(), user);
    }


    private void displayInputLevel() {
        System.out.println("Set user exercise level, beginner or experienced. [B/E] ");
        String value = getScanner().nextLine();
        Level level = new LevelInputField().tryParseUserLevel(value);

        if (level != null) {
            getInputFields().put("userLevel", new LevelInputField(level));
            display(Display.SUCCESS);
        } else {
            System.out.println("Invalid input. Try again.");
            display(Display.FAIL);
        }
    }
}