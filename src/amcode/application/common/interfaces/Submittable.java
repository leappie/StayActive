package amcode.application.common.interfaces;

import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public interface Submittable<T> {
    DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<T> controller);


}
