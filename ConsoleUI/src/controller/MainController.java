package controller;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.User;
import factory.ViewFactory;
import model.UserMainViewModel;
import persistence.useralert.UserAlertDAO;
import services.MainService;
import view.form.input.StringInputField;

import java.util.HashMap;

public class MainController implements Controller<UserMainViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        int choice = (int) inputField.get("mainViewChoice").getValue();
        switch (choice) {
//            case 1:
//                view = View.PROFILE_VIEW;
//                screen = Display.MAIN;
//                break;
            case 2:
                // get all alerts for current user
                User loggedInUser = CurrentUserService.getLoggedInUser();
                new MainService(new UserAlertDAO()).getUserNAlerts(loggedInUser); // TODO: improve?

                view = View.ALERT_OPTIONS_VIEW;
                screen = Display.MAIN;
                break;
//            case 3:
//                view = View.EXERCISE_HISTORY_VIEW;
//                screen = Display.MAIN;
//                break;
            case 4:
                view = View.MAIN_VIEW;
                screen = Display.QUIT;
                break;
            default:
                view = View.MAIN_VIEW;
                screen = Display.FAIL;
                break;
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }
}
