package amcode.view;


import amcode.controller.Controller;
import amcode.model.domain.User;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;
import amcode.view.form.input.StringInputField;

import java.util.HashMap;

public class ModifyAlertView extends FormView<User> {

    public ModifyAlertView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(DisplayEnum display) {

        switch (display) {
            case MAIN:
                break;
            case SUCCESS:
                break;
            case FAIL:
                break;
            default:
                break;
        }
    }


    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {


    }


}
