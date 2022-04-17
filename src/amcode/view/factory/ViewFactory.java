package amcode.view.factory;


import amcode.controller.Controller;
import amcode.view.LoginView;
import amcode.view.form.FormView;

import java.util.HashMap;

public class ViewFactory {

    public static FormView getView(Controller controller, ViewEnum viewName) {
        FormView view;

        switch (viewName) {
            case ALERT_LIST:
                view = null;
                break;
            case MAIN:
                view = null;
                break;
            case EXERCISE_HISTORY:
                view = null;
                break;
            case MODIFY_ALERT:
                view = null;
                break;
            case LOGIN:
                view = new LoginView(new HashMap<>(), controller);
                break;
            case NEW_ALERT:
                view = null;
                break;
            case PROFILE:
                view = null;
                break;
            default:
                view = null;
                break;
        }

        return view;
    }
}
