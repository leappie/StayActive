package amcode.consolui.view.form.input;

import java.time.LocalTime;

public class TimeInputField extends InputField<String>{
    public TimeInputField(String value) {
        super(value);
    }

    @Override
    protected String tryParse(String value) {
        return null;
    }

    public LocalTime getTimeValue() {
        LocalTime time = LocalTime.parse(getValue());

        return time;
    }
}
