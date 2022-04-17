package amcode.consolui.view.form.input;

import amcode.application.interfaces.Validator;

import java.util.ArrayList;
import java.util.List;

public abstract class InputField<T> {
    private T value;
    List<Validator<T>> validatorList;

    public InputField(T value, List<Validator<T>> validatorList) {
        this.value = value;
        this.validatorList = validatorList;
    }

    public InputField(T value) {
        this(value, new ArrayList<>());
    }

    public InputField(List<Validator<T>> validatorList) {
        this.validatorList = validatorList;
    }

    public boolean trySetValue(T value) {
        this.value = value;
        return true;
    }

    public T getValue() {
        return value;
    }

    protected abstract T tryParse(String value);

}