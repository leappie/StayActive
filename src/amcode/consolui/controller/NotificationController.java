package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.NotificationViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class NotificationController implements Controller<NotificationViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NotificationViewModel model) {
        return null;
    }
}
