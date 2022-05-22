package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.interfaces.repositories.IUserRepository;
import common.mapping.NewUserViewModelMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import entity.User;
import factory.ViewFactory;
import model.NewUserViewModel;
import persistence.daotests.user.UserDAO;
import services.NewAccountService;
import user.UserRepository;
import user.services.Authenticate;

import java.util.HashMap;

public class NewAccountController implements Controller<NewUserViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NewUserViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        User user = new NewUserViewModelMapping().mapToEntity(model);
        if (user.getLevel() == null) {
            view = View.NEW_ACCOUNT_VIEW;
            screen = Display.SUCCESS;
        } else {
            IUserRepository userRepository = new UserRepository(new UserDAO());
            boolean check = new NewAccountService(new Authenticate(userRepository)).authenticateUser(user);

            if (check) {
                view = View.START_VIEW;
                screen = Display.MAIN;
            } else {
                view = View.NEW_ACCOUNT_VIEW;
                screen = Display.FAIL;
            }
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }
}
