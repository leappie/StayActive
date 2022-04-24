package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.application.common.services.Authenticate;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.UserInputField;
import amcode.domain.entity.User;

import java.util.HashMap;

public class LoginController implements Controller<User> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, User model) {
        inputField = new HashMap<>();
        Authenticate authenticate = new Authenticate();
        FormView formView;
        Display display;

        final User user = authenticate.authenticateUser(model);

        if (user != null) {
            inputField.put("loggedInUser", new UserInputField(user));
            formView = ViewFactory.getView(inputField, View.MAIN_VIEW);
            display = Display.MAIN;
        } else {
            formView = ViewFactory.getView(inputField,this, View.LOGIN_VIEW);
            display = Display.FAIL;
        }
        return new DisplayScreen(formView, display);
    }


}
