package amcode.consolui.view.form.input;

import amcode.domain.entity.User;

public class UserInputField extends InputField<User> {
    public UserInputField(User value) {
        super(value);
    }

    @Override
    protected User tryParse(String value) {
        return null;
    }
}
