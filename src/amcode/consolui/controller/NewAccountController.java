package amcode.consolui.controller;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.NewUserViewModel;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class NewAccountController implements Controller<NewUserViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, NewUserViewModel model) {
//        Authenticate authenticate = new Authenticate();
//        FormView formView;
//        Display display;
//
//        final boolean check = authenticate.tryAddUser(model);
//
//        if (check) {
//            formView = ViewFactory.getView(View.LOGIN_VIEW);
//        } else {
//            formView = ViewFactory.getView(View.NEW_ACCOUNT_VIEW);
//        }
//        display = Display.MAIN;
//
//        return new DisplayScreen(formView, display);
        return null;
    }
}
