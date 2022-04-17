package amcode.view.factory;


import amcode.controller.*;
import amcode.view.*;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public class ViewFactory {

    public static FormView getView(ViewEnum viewName) {
        FormView view;
        Controller controller;
        HashMap<String, InputField> inputField = new HashMap<>();

        switch (viewName) {
            case ALERT_LIST_VIEW:
                controller = new AlertListController();
                view = new AlertListView(inputField, controller);
                break;
            case MAIN_VIEW:
                controller = new MainController();
                view = new MainView(inputField, controller);
                break;
            case EXERCISE_HISTORY_VIEW:
                controller = new ExerciseHistoryController();
                view = new ExerciseHistoryView(inputField, controller);
                break;
            case MODIFY_ALERT_VIEW:
                controller = new ModifyAlertController();
                view = new ModifyAlertView(inputField, controller);
                break;
            case LOGIN_VIEW:
                controller = new LoginController();
                view = new LoginView(inputField, controller);
                break;
            case NEW_ALERT_VIEW:
                controller = new NewAlertController();
                view = new NewAlertView(inputField, controller);
                break;
            case PROFILE_VIEW:
                controller = new ProfileController();
                view = new ProfileView(inputField, controller);
                break;
            default:
                view = null;
                break;
        }
        return view;
    }

    public static FormView getView(HashMap<String, InputField> inputField, ViewEnum viewName) {
        FormView view;
        Controller controller;

        switch (viewName) {
            case ALERT_LIST_VIEW:
                controller = new AlertListController();
                view = new AlertListView(inputField, controller);
                break;
            case MAIN_VIEW:
                controller = new MainController();
                view = new MainView(inputField, controller);
                break;
            case EXERCISE_HISTORY_VIEW:
                controller = new ExerciseHistoryController();
                view = new ExerciseHistoryView(inputField, controller);
                break;
            case MODIFY_ALERT_VIEW:
                controller = new ModifyAlertController();
                view = new ModifyAlertView(inputField, controller);
                break;
            case LOGIN_VIEW:
                controller = new LoginController();
                view = new LoginView(inputField, controller);
                break;
            case NEW_ALERT_VIEW:
                controller = new NewAlertController();
                view = new NewAlertView(inputField, controller);
                break;
            case PROFILE_VIEW:
                controller = new ProfileController();
                view = new ProfileView(inputField, controller);
                break;
            default:
                view = null;
                break;
        }
        return view;
    }

    public static FormView getView(HashMap<String, InputField> inputField, Controller controller, ViewEnum viewName) {
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
            default:
                view = null;
                break;
        }
        return view;
    }
}
