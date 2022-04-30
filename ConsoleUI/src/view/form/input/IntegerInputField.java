package view.form.input;

import common.models.InputField;

public class IntegerInputField extends InputField<Integer> {
    public IntegerInputField(Integer value) {
        super(value);
    }

    @Override
    protected Integer tryParse(String value) {
        return null;
    }
}
