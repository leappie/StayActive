package amcode.consolui.view.form;

import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public abstract class InfoView<T> extends FormView<T>{


    public InfoView(HashMap<String, InputField> inputFields, String screenTitle) {
        super(inputFields, null, screenTitle);
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<T> controller) {
        return null;
    }
}
