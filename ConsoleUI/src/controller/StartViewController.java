package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.UserMainViewModel;

import java.util.HashMap;

public class StartViewController implements Controller<UserMainViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        int choice = (int) inputField.get("startViewChoice").getValue();

        switch (choice) {
            case 1:
                view = View.LOGIN_VIEW;
                screen = Display.MAIN;
                break;
//            case 2:
//                // TODO: NEW ACCOUNT
//                view = View.NEW_ACCOUNT_VIEW;
//                break;
//            case 3:
//                // TODO: FORGOT PASSWORD
//                view = View.FORGOT_PASSWORD_VIEW;
//                break;
            case 4:
                view = View.START_VIEW;
                screen = Display.QUIT;
                break;
            default:
                view = View.START_VIEW;
                screen = Display.FAIL;
                break;
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }
}
