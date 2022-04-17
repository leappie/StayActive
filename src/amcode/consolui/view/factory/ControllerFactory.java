package amcode.consolui.view.factory;

import amcode.application.enums.View;
import amcode.application.interfaces.Controller;
import amcode.consolui.controller.*;
import amcode.consolui.view.*;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class ControllerFactory {

    public static Controller getController(View viewName) {
        Controller controller;

        switch (viewName) {
            case ALERT_LIST_VIEW:
                controller = new AlertListController();
                break;
            case MAIN_VIEW:
                controller = new MainController();
                break;
            case EXERCISE_HISTORY_VIEW:
                controller = new ExerciseHistoryController();
                break;
            case MODIFY_ALERT_VIEW:
                controller = new ModifyAlertController();
                break;
            case LOGIN_VIEW:
                controller = new LoginController();
                break;
            case NEW_ALERT_VIEW:
                controller = new NewAlertController();
                break;
            case PROFILE_VIEW:
                controller = new ProfileController();
                break;
            case NEW_ACCOUNT_VIEW:
                controller = new NewAccountController();
                break;
//            case NOTIFICATION_VIEW:
//                break;
//            case ON_EXERCISE_VIEW:
//                break;
            default:
                controller = null;
                break;
        }
        return controller;
    }
}
