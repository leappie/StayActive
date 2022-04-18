package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.services.Authenticate;
import amcode.consolui.view.LoginView;
import amcode.consolui.view.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.UserInputField;
import amcode.domain.model.User;
import amcode.domain.services.UserControl;

import java.util.HashMap;

public class LoginController implements Controller<User> {

    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        inputField = new HashMap<>();
        UserControl userControl = new UserControl();
        FormView formView;

        final User user = userControl.authenticateUser(model);

        if (user != null) {
            inputField.put("logged_in_user", new UserInputField(user));
            formView = ViewFactory.getView(inputField, View.MAIN_VIEW);
            formView.display(Display.MAIN);
        } else {
            formView = new LoginView(inputField, this);
            formView.display(Display.FAIL);
        }
        return formView;
    }


}
