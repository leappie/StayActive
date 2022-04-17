package amcode.controller;


import amcode.model.domain.User;
import amcode.model.services.Authenticate;
import amcode.view.LoginView;
import amcode.view.factory.ViewEnum;
import amcode.view.factory.ViewFactory;
import amcode.view.form.DisplayEnum;
import amcode.view.form.Displayable;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;
import amcode.view.form.input.UserInputField;

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
            formView = ViewFactory.getView(newInputField, ViewEnum.MAIN_VIEW);
            formView.display(DisplayEnum.MAIN);
        } else {
            formView = new LoginView(newInputField, this);
            formView.display(DisplayEnum.FAIL);
        }
        return formView;
    }


}
