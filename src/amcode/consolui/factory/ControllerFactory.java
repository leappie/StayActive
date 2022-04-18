package amcode.consolui.factory;

import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.controller.*;

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
