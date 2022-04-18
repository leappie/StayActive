package amcode.consolui.view.form.input.validation;

import amcode.application.common.interfaces.Validator;

public class IntegerRequiredValidation implements Validator<Integer> {
    @Override
    public String invalidValueMessage() {
        return null;
    }

    @Override
    public boolean isValid(Integer value) {
        return false;
    }
}
