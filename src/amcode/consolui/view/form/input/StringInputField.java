package amcode.consolui.view.form.input;

public class StringInputField extends InputField<String> {
    public StringInputField(String value) {
        super(value);
    }

    @Override
    protected String tryParse(String value) {
        return null;
    }


}
