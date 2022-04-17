package amcode.view.form.input;

import java.time.LocalTime;

public class StringToTimeInputField extends InputField<String>{
    public StringToTimeInputField(String value) {
        super(value);
    }

    public LocalTime getTimeValue() {
        LocalTime time = LocalTime.parse(getValue());

        return time;
    }
}
