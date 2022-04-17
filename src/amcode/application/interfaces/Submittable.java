package amcode.application.interfaces;

import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public interface Submittable<T> {
    void submit(HashMap<String, InputField> inputFields, Controller<T> controller);
}
