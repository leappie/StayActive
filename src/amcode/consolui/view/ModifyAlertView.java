package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class ModifyAlertView extends FormView<AlertViewModel> {

    public ModifyAlertView(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();
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
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller) {
        return null;
    }


}