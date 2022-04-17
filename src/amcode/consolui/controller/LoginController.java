package amcode.consolui.controller;

import amcode.application.enums.Display;
import amcode.application.enums.View;
import amcode.application.interfaces.Controller;
import amcode.application.interfaces.Displayable;
import amcode.application.services.Authenticate;
import amcode.consolui.view.LoginView;
import amcode.consolui.view.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.UserInputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class LoginController implements Controller<User> {

    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        HashMap<String, InputField> newInputField = new HashMap<>();
        Authenticate authenticate = new Authenticate();
        FormView formView;

        final User user = authenticate.authenticateUser(model);
        newInputField.put("logged_in_user", new UserInputField(user));

        if (user != null) {
            formView = ViewFactory.getView(newInputField, View.MAIN_VIEW);
            formView.display(Display.MAIN);
        } else {
            formView = new LoginView(newInputField, this);
            formView.display(Display.FAIL);
        }
        return formView;
    }


}
