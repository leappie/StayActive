package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.LevelInputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.domain.enums.Level;
import amcode.domain.model.User;

import java.util.HashMap;

public class NewAccountView extends FormView<User> {
    public NewAccountView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {
        String username;
        String password;
        String value;
        switch (display) {
            case MAIN:
                System.out.println("Set username: ");
                username = getScanner().nextLine();
                System.out.println("Set password: ");
                password = getScanner().nextLine();
                value = displayInputLevel();
                value = checkInput(value);

                Level level = new LevelInputField().tryParse(value);

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));
                getInputFields().put("user_level", new LevelInputField(level));

                submit(getInputFields(), getController());
                break;
            case FAIL:
                value = displayInputLevel();
                value = checkInput(value);

                level = new LevelInputField().tryParse(value);
                getInputFields().put("user_level", new LevelInputField(level));

                break;
            default:
                break;
        }
    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        final Level level = (Level) getInputFields().get("user_level").getValue();

        User user = new User(username, password, level);

        controller.execute(getInputFields(), user);
    }

    private String checkInput(String value) {
        if (value.equalsIgnoreCase("b")) {
            value = "EASY";
        } else if (value.equalsIgnoreCase("e")) {
            value = "MEDIUM";
        } else {
            System.out.println("Invalid input for level. Try again.");
            display(Display.FAIL);
        }
        return value;
    }

    private String displayInputLevel() {
        System.out.println("Set user exercise experience, beginner or experienced. [B/E] ");
        String value = getScanner().nextLine();

        return value;
    }
}