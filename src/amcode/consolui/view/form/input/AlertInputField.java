package amcode.consolui.view.form.input;

import amcode.domain.entity.Alert;

public class AlertInputField extends InputField<Alert> {
    public AlertInputField(Alert value) {
        super(value);
    }

    public AlertInputField() {
    }

    @Override
    protected Alert tryParse(String value) {
        return null;
    }
}
