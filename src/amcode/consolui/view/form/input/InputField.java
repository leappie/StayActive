package amcode.consolui.view.form.input;

import amcode.application.interfaces.Validator;

import java.util.ArrayList;
import java.util.List;

public abstract class InputField<T> {
    private T value;

    public InputField(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }


    protected abstract T tryParse(String value);

}