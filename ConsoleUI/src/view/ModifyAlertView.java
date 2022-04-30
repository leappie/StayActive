package view;


import common.enums.Display;
import common.interfaces.Controller;
import common.models.DisplayScreen;
import common.models.InputField;
import model.AlertViewModel;
import view.form.FormView;

import java.util.HashMap;

//TODO:
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