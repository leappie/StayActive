package view.form.input;

import common.models.InputField;

public class StringInputField extends InputField<String> {
    public StringInputField(String value) {
        super(value);
    }

    @Override
    protected String tryParse(String value) {
        return null;
    }


}
