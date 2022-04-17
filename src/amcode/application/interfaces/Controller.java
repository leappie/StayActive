package amcode.application.interfaces;

import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public interface Controller<T> {
    Displayable execute(HashMap<String, InputField> inputField, T model);

}
