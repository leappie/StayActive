package amcode.consolui.view.factory;

import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.*;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class ViewFactory {

    public static FormView getView(View viewName) {
        HashMap<String, InputField> inputField = new HashMap<>();
        FormView formView = getView(inputField, viewName);

        return formView;
    }

    public static FormView getView(HashMap<String, InputField> inputField, View viewName) {
        FormView view;
        Controller controller = ControllerFactory.getController(viewName);
        FormView formView = getView(inputField, controller, viewName);

        return formView;
    }

    public static FormView getView(HashMap<String, InputField> inputField, Controller controller, View viewName) {
        FormView view;

        switch (viewName) {
            case ALERT_LIST_VIEW:
                view = new AlertListView(inputField, controller);
                break;
            case MAIN_VIEW:
                view = new MainView(inputField, controller);
                break;
            case EXERCISE_HISTORY_VIEW:
                view = new ExerciseHistoryView(inputField, controller);
                break;
            case MODIFY_ALERT_VIEW:
                view = new ModifyAlertView(inputField, controller);
                break;
            case LOGIN_VIEW:
                view = new LoginView(inputField, controller);
                break;
            case NEW_ALERT_VIEW:
                view = new NewAlertView(inputField, controller);
                break;
            case PROFILE_VIEW:
                view = new ProfileView(inputField, controller);
                break;
            case NEW_ACCOUNT_VIEW:
                view = new NewAccountView(inputField, controller);
                break;
//            case NOTIFICATION_VIEW:
//                view = new NotificationView(inputField, controller);
//                break;
//            case ON_EXERCISE_VIEW:
//                view = new OnExerciseView(inputField, controller);
//                break;
            default:
                view = null;
                break;
        }
        return view;
    }
}
