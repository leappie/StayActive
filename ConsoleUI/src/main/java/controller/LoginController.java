package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.mapping.UserLoginViewMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import entity.User;
import factory.ViewFactory;
import model.UserLoginViewModel;
import persistence.user.UserDAO;
import services.LoginService;
import user.UserRepository;
import user.services.Authenticate;

import java.util.HashMap;

public class LoginController implements Controller<UserLoginViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserLoginViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        User user = new UserLoginViewMapping().mapToEntity(model);
        UserRepository userRepository = new UserRepository(new UserDAO());
        user = new LoginService(new Authenticate(userRepository)).authenticateUser(user); // TODO: improve?

        if (user != null) {
            view = View.MAIN_VIEW;
            screen = Display.MAIN;
        } else {
            view = View.LOGIN_VIEW;
            screen = Display.FAIL;
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }


}
