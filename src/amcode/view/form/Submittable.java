package amcode.view.form;

import amcode.controller.Controller;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public interface Submittable<T> {
    void submit(HashMap<String, InputField> inputFields, Controller<T> controller);
}
