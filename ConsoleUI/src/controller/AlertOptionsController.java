package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.UserMainViewModel;

import java.util.HashMap;

public class AlertOptionsController implements Controller<UserMainViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        int choice = (int) inputField.get("alertOptionsViewChoice").getValue();
        switch (choice) {
            case 1:
                view = View.NEW_ALERT_VIEW;
                screen = Display.MAIN;
                break;
//            case 2:
//                // TODO: Modify Alert
//                view = View.MODIFY_ALERT_VIEW;
//                screen = Display.MAIN;
//                break;
//            case 3:
//                // TODO: Delete Alert
//                view = View.DELETE_ALERT_VIEW;
//                screen = Display.MAIN;
//                break;
            case 4:
                view = View.TRIGGER_ALERT_VIEW;
                screen = Display.MAIN;
                break;
            case 5:
                view = View.MAIN_VIEW;
                screen = Display.MAIN;
                break;
            case 6:
                view = View.ALERT_OPTIONS_VIEW;
                screen = Display.QUIT;
                break;
            default:
                view = View.ALERT_OPTIONS_VIEW;
                screen = Display.FAIL;
                break;
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }
}
