package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.DAO;
import common.interfaces.Displayable;
import common.mapping.UserLoginViewMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import entity.User;
import factory.ViewFactory;
import model.UserLoginViewModel;
import persistence.user.UserDAO;
import services.LoginService;

import java.util.HashMap;

public class LoginController implements Controller<UserLoginViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserLoginViewModel model) {
        Displayable displayable;
        Display display;

        User user = new UserLoginViewMapping().mapTo(model);
        user = new LoginService(new UserDAO()).authenticateUser(user); // TODO: improve?

        if (user != null) {
            displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
            display = Display.MAIN;
        } else {
            displayable = ViewFactory.getView(inputField, this, View.LOGIN_VIEW);
            display = Display.FAIL;
        }
        return new DisplayScreen(displayable, display);
    }


}
