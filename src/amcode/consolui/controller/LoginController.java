package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.application.user.UserRepository;
import amcode.application.user.services.Authenticate;
import amcode.consolui.common.mapping.UserLoginViewMapping;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.UserLoginViewModel;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.user.UserDao;

import java.util.HashMap;

public class LoginController implements Controller<UserLoginViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserLoginViewModel model) {
        Displayable displayable;
        Display display;

        User user = new UserLoginViewMapping().mapTo(model);
        user = new Authenticate(new UserRepository(new UserDao())).authenticateUser(user);

        if (user != null) {
            CurrentUserService.setLoggedInUser(user);
            displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
            display = Display.MAIN;
        } else {
            displayable = ViewFactory.getView(inputField, this, View.LOGIN_VIEW);
            display = Display.FAIL;
        }
        return new DisplayScreen(displayable, display);
    }


}
