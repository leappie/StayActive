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

import java.util.HashMap;

public class MainController implements Controller<UserMainViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        View view = View.valueOf((String) inputField.get("showNextView").getValue());
        Displayable displayable;
        Display display;

        switch (view) {
            case PROFILE_VIEW:
                // TODO: Get profile
                displayable = ViewFactory.getView(inputField, View.PROFILE_VIEW);
                break;
            case ALERT_OPTIONS_VIEW:
                // get all alerts for current user
                User loggedInUser = CurrentUserService.getLoggedInUser();
                new MainService(new UserAlertDAO()).getUserNAlerts(loggedInUser); // TODO: improve?

                displayable = ViewFactory.getView(inputField, View.ALERT_OPTIONS_VIEW);
                break;
            case EXERCISE_HISTORY_VIEW:
                // TODO: Get exercise history
                displayable = ViewFactory.getView(inputField, View.EXERCISE_HISTORY_VIEW);
                break;
            default:
                displayable = null;
                break;
        }
        display = Display.MAIN;

        return new DisplayScreen(displayable, display);
    }
}
