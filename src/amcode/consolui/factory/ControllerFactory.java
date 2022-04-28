package amcode.consolui.factory;

import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.controller.*;

public class ControllerFactory {

    public static Controller getController(View viewName) {
        Controller controller;

        switch (viewName) {
            case MAIN_VIEW:
                controller = new MainController();
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
            case NEW_ACCOUNT_VIEW:
                controller = new NewAccountController();
                break;
            case TRIGGER_ALERT_VIEW:
                controller = new TriggerAlertController();
                break;
            case NOTIFICATION_VIEW:
                controller = new NotificationController();
                break;
//            case ON_EXERCISE_VIEW:
//                controller = new OnExerciseController();
//                break;
            default:
                controller = null;
                break;
        }
        return controller;
    }
}
