package amcode.consolui.view.form.input;

public class IntegerInputField extends InputField<Integer> {
    public IntegerInputField(Integer value) {
        super(value);
    }

    @Override
    protected Integer tryParse(String value) {
        return null;
    }


}
