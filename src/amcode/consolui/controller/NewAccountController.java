package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.User;
import amcode.domain.services.UserControl;

import java.util.HashMap;

public class NewAccountController implements Controller<User> {
    @Override
    public Displayable execute(HashMap<String, InputField> inputField, User model) {
        UserControl userControl = new UserControl();
        FormView formView;

        /*
        try add user to the database
        on conflict return false
        if true go to the login page
        else go back and try again
         */
        final boolean check = userControl.tryAddUser(model);

        if (check) {
            formView = ViewFactory.getView(View.LOGIN_VIEW);
            formView.display(Display.MAIN);
        } else {
            formView = ViewFactory.getView(View.NEW_ACCOUNT_VIEW);
            formView.display(Display.MAIN);
        }
        return formView;
    }
}
