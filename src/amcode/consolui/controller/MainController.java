package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.UserMainViewModel;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.HashMap;
import java.util.List;

import static amcode.application.common.enums.Display.MAIN;

public class MainController implements Controller<UserMainViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        View view = View.valueOf((String) inputField.get("showNextView").getValue());
        Displayable displayable;
        Display display;

        switch (view) {
            case PROFILE_VIEW:
                // TODO
                break;
            case ALERT_LIST_VIEW:
                // get all alert for current user
                User loggedInUser = CurrentUserService.getLoggedInUser();
//                loggedInUser = new UserRepository(new UserDao()).getUserAlerts(loggedInUser);

                // get all alert exercises for all alerts
                List<Alert> alertList = loggedInUser.getAlertList();

                displayable = ViewFactory.getView(inputField, View.MAIN_VIEW);
                display = MAIN;




                break;
            case EXERCISE_HISTORY_VIEW:
                // TODO
                break;
        }

        return null;
    }
}
