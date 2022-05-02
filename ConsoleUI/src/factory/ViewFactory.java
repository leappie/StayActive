package factory;


import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.InputField;
import view.*;
import view.form.FormView;

import java.util.HashMap;

public class ViewFactory {

    public static Displayable getView(View viewName) {
        HashMap<String, InputField> inputField = new HashMap<>();
        Displayable displayable = getView(inputField, viewName);

        return displayable;
    }

    public static Displayable getView(HashMap<String, InputField> inputField, View viewName) {
        Controller controller = ControllerFactory.getController(viewName);
        Displayable displayable = getView(inputField, controller, viewName);

        return displayable;
    }

    public static Displayable getView(HashMap<String, InputField> inputField, Controller controller, View viewName) {
        Displayable displayable;

        switch (viewName) {
            case ALERT_OPTIONS_VIEW:
                displayable = new AlertOptionsView(inputField, controller,"Alerts");
                break;
            case MAIN_VIEW:
                displayable = new MainView(inputField, controller,"Home");
                break;
            case EXERCISE_HISTORY_VIEW:
                displayable = new ExerciseHistoryView(inputField, controller, "Exercise history");
                break;
            case MODIFY_ALERT_VIEW:
                displayable = new ModifyAlertView(inputField, controller, "Change alert");
                break;
            case LOGIN_VIEW:
                displayable = new LoginView(inputField, controller, "Login");
                break;
            case NEW_ALERT_VIEW:
                displayable = new NewAlertView(inputField, controller, "New alert");
                break;
            case PROFILE_VIEW:
                displayable = new ProfileView(inputField, controller, "Profile");
                break;
            case NEW_ACCOUNT_VIEW:
                displayable = new NewAccountView(inputField, controller, "Create account");
                break;
            case START_VIEW:
                displayable = new StartView(inputField, controller,"StayActive");
                break;
            case TRIGGER_ALERT_VIEW:
                displayable = new TriggerAlertView(inputField, controller, "Trigger alert");
                break;
            case NOTIFICATION_VIEW:
                displayable = new NotificationView(inputField, controller,"!!Notification!!");
                break;
            default:
                displayable = null;
                break;
        }
        return displayable;
    }


}
