package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.services.Authenticate;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.UserInputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class LoginController implements Controller<User> {

    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        inputField = new HashMap<>();
        Authenticate authenticate = new Authenticate();
        FormView formView;

        /*
        try authenticate user
        if successful get the user from the database and proceed to the main view
        else go back and try again
         */
        final User user = authenticate.authenticateUser(model);

        if (user != null) {
            inputField.put("loggedInUser", new UserInputField(user));
            formView = ViewFactory.getView(inputField, View.MAIN_VIEW);
            formView.display(Display.MAIN);
        } else {
            formView = ViewFactory.getView(inputField,this, View.LOGIN_VIEW);
            formView.display(Display.FAIL);
        }
        return formView;
    }


}
