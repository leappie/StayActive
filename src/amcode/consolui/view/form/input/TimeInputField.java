package amcode.consolui.view.form.input;

import java.time.LocalTime;

public class TimeInputField extends InputField<LocalTime>{

    public TimeInputField(LocalTime value) {
        super(value);
    }

    public TimeInputField() {
    }

    @Override
    protected LocalTime tryParse(String value) {
        return null;
    }
}
