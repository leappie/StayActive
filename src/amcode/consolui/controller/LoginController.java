package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.UserLoginViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class LoginController implements Controller<UserLoginViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserLoginViewModel model) {
//        Displayable displayable;
//        Display display;
//
//        User user = new UserLoginMapping().mapTo(model);
//        user = new Authenticate(new UserRepository()).authenticateUser(user);
//
//        if (user != null) {
//            CurrentUserService.setLoggedInUser(user);
//            displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
//            display = Display.MAIN;
//        } else {
//            displayable = ViewFactory.getView(inputField, this, View.LOGIN_VIEW);
//            display = Display.FAIL;
//        }
//        return new DisplayScreen(displayable, display);

        return null;
    }


}
