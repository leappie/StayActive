package amcode.consolui.view;

import amcode.application.enums.Display;
import amcode.application.interfaces.Controller;
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
        switch (display) {
            case MAIN:
                System.out.println("Set username: ");
                String username = getScanner().nextLine();
                System.out.println("Set password: ");
                String password = getScanner().nextLine();
                System.out.println("Set user exercise experience, beginner or experienced. [B/E] ");
                String value = getScanner().nextLine();

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));
//                getInputFields().put("user_level", new LevelInputField().tryParse(value))

                submit(getInputFields(), getController());
                break;
            case FAIL:

                break;
            default:
                break;
        }
    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {

    }

    private String convertInput(String value) {
        if (value.equalsIgnoreCase("b")) {
            value = "EASY";
        } else if (value.equalsIgnoreCase("e")) {
            value = "MEDIUM";
        } else {
            System.out.println("Invalid input.");
            display(Display.MAIN);
        }
        return value;
    }
}