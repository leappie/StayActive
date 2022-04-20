package amcode.application.common.interfaces;

import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public interface Controller<T> {
    DisplayScreen execute(HashMap<String, InputField> inputField, T model);

}
