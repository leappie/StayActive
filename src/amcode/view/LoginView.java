package amcode.view;

import amcode.controller.Controller;
import amcode.model.domain.User;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;
import amcode.view.form.input.StringInputField;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginView extends FormView<User> {

    public LoginView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(DisplayEnum display) {

        switch (display) {
            case MAIN:
                System.out.println("Enter username: ");
                String username = getScanner().nextLine();
                System.out.println("Enter password: ");
                String password = getScanner().nextLine();
                // TODO: Validate input

                getInputFields().put("username", new StringInputField(username));
                getInputFields().put("password", new StringInputField(password));

                submit(getInputFields(), getController());
                break;
            case FAIL:
                System.out.println("Incorrect password or username.");
                System.out.println("Try again? [Y/N]");

                String choice = getScanner().nextLine();
                // TODO: Validate input

                if(choice.equalsIgnoreCase("y")) {
                    display(DisplayEnum.MAIN);
                } else {
                    System.out.println("Create a new account? [Y/N]");

                    choice = getScanner().nextLine();
                    // TODO: Validate input
                }
                // else: Quit app
                break;
            default:
                break;
        }
    }


    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        User user = new User(username, password);

        controller.execute(getInputFields(), user);
    }





}
