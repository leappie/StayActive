package amcode.controller;

import amcode.view.form.Displayable;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public interface Controller<T> {
    Displayable execute(HashMap<String, InputField> inputField, T model);

}
