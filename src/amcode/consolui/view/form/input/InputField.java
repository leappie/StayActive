package amcode.consolui.view.form.input;

public abstract class InputField<T> {
    private T value;

    public InputField(T value) {
        this.value = value;
    }

    public InputField() {
        this(null);
    }

    public void SetValue(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }


    protected abstract T tryParse(String value);

}