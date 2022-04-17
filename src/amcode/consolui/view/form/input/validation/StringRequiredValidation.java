package amcode.consolui.view.form.input.validation;

import amcode.application.interfaces.Validator;

public class StringRequiredValidation implements Validator<String> {
    @Override
    public String invalidValueMessage() {
        return null;
    }

    @Override
    public boolean isValid(String value) {
        return false;
    }
}
