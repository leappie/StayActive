package amcode.consolui.controller;

import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.UserMainViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class MainController implements Controller<UserMainViewModel> {

    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, UserMainViewModel model) {
        View view = View.valueOf((String) inputField.get("showNextView").getValue());

        switch (view) {
            case PROFILE_VIEW:
                // TODO
                break;
            case ALERT_LIST_VIEW:
                // TODO
                // get all alert for current user
                // get all alert exercises for all alerts

                break;
            case EXERCISE_HISTORY_VIEW:
                // TODO
                break;
        }

        return null;
    }
}
