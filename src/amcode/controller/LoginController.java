package amcode.controller;


import amcode.model.domain.User;
import amcode.model.services.Authenticate;
import amcode.view.LoginView;
import amcode.view.MainView;
import amcode.view.form.DisplayEnum;
import amcode.view.form.Displayable;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;
import amcode.view.form.input.UserInputField;

import java.util.HashMap;

public class LoginController implements Controller<User> {

    @Override
    public Displayable execute(User model) {
        Authenticate authenticate = new Authenticate();
        final User user = authenticate.authenticateUser(model);
        HashMap<String, InputField> inputField = new HashMap<>();
        inputField.put("loggedinuser", new UserInputField(user));
        FormView formView;

        if (user != null) {
            Controller controller = new MainController();
            formView = new MainView(inputField, controller);

            formView.display(DisplayEnum.MAIN);
        } else {
            formView = new LoginView(inputField, this);

            formView.display(DisplayEnum.FAIL);
        }
        return formView;
    }


}
