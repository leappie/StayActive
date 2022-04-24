package amcode.consolui.controller;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.application.common.services.Authenticate;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.User;

import java.util.HashMap;

public class NewAccountController implements Controller<User> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, User model) {
        Authenticate authenticate = new Authenticate();
        FormView formView;
        Display display;

        final boolean check = authenticate.tryAddUser(model);

        if (check) {
            formView = ViewFactory.getView(View.LOGIN_VIEW);
        } else {
            formView = ViewFactory.getView(View.NEW_ACCOUNT_VIEW);
        }
        display = Display.MAIN;

        return new DisplayScreen(formView, display);
    }
}
